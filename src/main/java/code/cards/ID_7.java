package code.cards;

import code.actions.Id7Action;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;

public class ID_7 extends AbstractEasyCard {
    public final static String ID = makeID("ID_7");
    // intellij stuff SKILL, PLAYER, RARE, 0, 0, 0, 0, 0, 0

    public ID_7() {
        super(ID, -1, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new Id7Action(this.upgraded));
    }

    public void upp() {
    }
}

