package code.cards;

import code.CharacterFile;
import code.actions.EasyXCostAction;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.WeakPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_56 extends AbstractEasyCard {
    public final static String ID = makeID("ID_56");
    // intellij stuff attack, enemy, common, 12, 2, 0, 0, 2, 1

    public ID_56() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 12;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 2;
        selfRetain = true;
        this.tags.add(CharacterFile.THEGUY_TAGS.Punch_THE_GUY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
    }

    public void upp() {
        upgradeDamage(2);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(2);
    }
}