package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;

import java.util.Iterator;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_23 extends AbstractEasyCard {
    public final static String ID = makeID("ID_23");
    // intellij stuff Attack, enemey, common, 3, 0, 0, 0, 1, 2

    public ID_23() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        baseDamage = 3;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        AbstractMonster mo;
        while(var3.hasNext()) {
            mo = (AbstractMonster)var3.next();
            if (!mo.isDeadOrEscaped()) {
                this.addToBot(new VFXAction(new LightningEffect(mo.drawX, mo.drawY), 0.05F));
            }
        }
        var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()) {
            mo = (AbstractMonster)var3.next();
            this.addToBot(new ApplyPowerAction(mo, p, new VulnerablePower(mo, 1, false), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        }

        //atb(new WaitAction(0.5f));
        this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
    }

    public void upp() {
        upgradeDamage(1);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        upgradeBaseCost(1);
    }
}