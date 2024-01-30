package code.cards;

import code.actions.ID_22Action;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.BetterDiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import org.apache.commons.lang3.ObjectUtils;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_22 extends AbstractEasyCard {
    public final static String ID = makeID("ID_22");
    // intellij stuff ATTACK, NONE, Common, 2, 3, 0, 0, 0, 0

    AbstractGameAction action;
    public ID_22() {
        super(ID, -2, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE);
        baseDamage = 2;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;

        this.action = new ID_22Action(this);
    }


    public void didDiscard() {
        AbstractPlayer p = AbstractDungeon.player;
        boolean check0 = p.discardPile.contains(this);
        boolean check1 = p.discardPile.getTopCard() != this;
        boolean check2 = !AbstractDungeon.actionManager.actions.contains(action);
        if(check0 && check1 && check2)
        {
            this.action.isDone = false;
            atb(this.action);
        }


    }
    public void use(AbstractPlayer p, AbstractMonster m){ }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return false;
    }
    @Override
    public void triggerOnManualDiscard()
    {
        this.addToBot(new DamageAllEnemiesAction(AbstractDungeon.player, damage , DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }

    public void upp() {
        upgradeDamage(1);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(0);
    }
}