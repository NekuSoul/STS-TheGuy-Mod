package code.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;

public class ID_1 extends AbstractEasyCard {
    public final static String ID = makeID("ID_1");
    // intellij stuff skill, self, basic, , ,  5, 3, , 

    public ID_1() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        setBlock(5, +3);
        tags.add(CardTags.STARTER_DEFEND);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }
}