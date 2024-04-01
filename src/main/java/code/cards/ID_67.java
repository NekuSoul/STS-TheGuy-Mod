package code.cards;

import code.actions.ID_67Action;
import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_67 extends AbstractEasyCard {
    public final static String ID = makeID("ID_67");
    // intellij stuff attack, enemy, common, 9, 3, 9, 9, 12, 6

    public ID_67() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 9;
        baseBlock = 0;
        baseMagicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ID_67Action(m,new DamageInfo(p,damage),magicNumber));
        applyToEnemy(m, new LambdaPower(makeID("ID_67_Power"), AbstractPower.PowerType.DEBUFF, false, p, damage) {


            @Override
            public void onDeath() {
                atb(new DamageAllEnemiesAction(AbstractDungeon.player,amount, DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
            }
        });

    }

    public void upp() {
        upgradeDamage(3);
        //upgradeBlock(0);
        //upgradeMagicNumber(6);
        //upgradeBaseCost(1);
    }
}