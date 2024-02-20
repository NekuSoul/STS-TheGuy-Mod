package code.cards;

import code.CharacterFile;
import code.cards.AbstractEasyCard;
import com.evacipated.cardcrawl.mod.stslib.util.UpgradeData;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_42 extends AbstractEasyCard {
    public final static String ID = makeID("ID_42");
    // intellij stuff attack, enemy, common, 3, 2, 0, 0, 0, 0

    public ID_42() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage=0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
        this.tags.add(CharacterFile.THEGUY_TAGS.Punch_THE_GUY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.calculateCardDamage(m);
        this.addToBot(new DamageAction(m, new DamageInfo(p, damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

        this.initializeDescription();
    }

    @Override
    public void calculateCardDamage(AbstractMonster mo)
    {
        if(mo != null)
            applyPowers();
        super.calculateCardDamage(mo);
        baseSecondDamage = damage;
        this.initializeDescription();
    }
    @Override
    public void calculateDamageDisplay(AbstractMonster mo)
    {
        calculateCardDamage(mo);
    }

    public void applyPowers()
    {
        baseDamage = AbstractDungeon.player.discardPile.size();
        calculateCardDamage((AbstractMonster) null);
        super.applyPowers();
        this.initializeDescription();
    }

    public void upp() {
        upgradeDamage(3);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(1);
    }
}