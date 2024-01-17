package code.cards;

import code.CharacterFile;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import javax.swing.*;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_55 extends AbstractEasyCard {
    public final static String ID = makeID("ID_55");
    // intellij stuff attack, all enemys, rare, 99, 1, 0, 0, 0, 0

    public ID_55() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 99;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
        this.tags.add(CharacterFile.THEGUY_TAGS.Punch_THE_GUY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new DamageAllEnemiesAction(p,damage, DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m)
    {
        java.util.Iterator<com.megacrit.cardcrawl.cards.AbstractCard> t = p.hand.group.iterator();
        while(true)
        {
            if(t.hasNext()) {
                AbstractCard c = t.next();
                if(c.hasTag(CharacterFile.THEGUY_TAGS.Punch_THE_GUY))                {
                    break;
                }
            }
            else{
                return false;
            }
        }
        t = p.discardPile.group.iterator();
        while(true)
        {
            if(t.hasNext()) {
                AbstractCard c = t.next();
                if(c.hasTag(CharacterFile.THEGUY_TAGS.Punch_THE_GUY))                {
                    break;
                }
            }
            else{
                return false;
            }
        }
        t = p.drawPile.group.iterator();
        while(true)
        {
            if(t.hasNext()) {
                AbstractCard c = t.next();
                if(c.hasTag(CharacterFile.THEGUY_TAGS.Punch_THE_GUY))                {
                    break;
                }
            }
            else{
                return false;
            }
        }
        t = p.exhaustPile.group.iterator();
        while(true)
        {
            if(t.hasNext()) {
                AbstractCard c = t.next();
                if(c.hasTag(CharacterFile.THEGUY_TAGS.Punch_THE_GUY))                {
                    break;
                }
            }
            else{
                return false;
            }
        }

        return true;
    }

    public void upp() {
        upgradeDamage(1);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(0);
    }
}