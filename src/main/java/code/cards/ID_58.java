package code.cards;

import code.CharacterFile;
import code.actions.EasyXCostAction;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_58 extends AbstractEasyCard {
    public final static String ID = makeID("ID_58");
    // intellij stuff attack, enemy, uncommon, 7, 10, 0, 0, 0, 0

    public ID_58() {
        super(ID, -1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 7;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
        this.tags.add(CharacterFile.THEGUY_TAGS.Punch_THE_GUY);
    }

    AbstractMonster m;
    AbstractPlayer p;

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.p = p;
        this.m = m;
        atb(new EasyXCostAction(this, this::action));
    }

    public boolean action(int amount, int[] params)
    {

        for(int i = 0; i < amount; ++i) {
            this.addToBot(new DamageAction(this.m, new DamageInfo(this.p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }
        return true;
    }

    public void upp() {
        upgradeDamage(10);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(-1);
    }
}