package code.cards;

import code.CharacterFile;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_5 extends AbstractEasyCard {
    public final static String ID = makeID("ID_5");
    // intellij stuff ATTACK, ENEMY, COMMON, 9, 3, 0, 0, 1, 0

    public ID_5() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 15;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
        this.tags.add(CharacterFile.THEGUY_TAGS.Punch_THE_GUY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);
        addToBot(new DiscardAction(p, p, magicNumber, false));
        addToBot(new DrawCardAction(magicNumber));
    }

    public void upp() {
        upgradeDamage(3);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(0);
    }
}