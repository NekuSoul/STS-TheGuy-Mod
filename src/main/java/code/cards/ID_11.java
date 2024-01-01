package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_11 extends AbstractEasyCard {
    public final static String ID = makeID("ID_11");
    // intellij stuff ATTACK, NONE, COMMON, 3, 1, 0, 0, 0, 0

    public ID_11() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.NONE);
        baseDamage = 3;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        int count = 0;
        Iterator var4 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        while(var4.hasNext()) {
            AbstractMonster m2 = (AbstractMonster)var4.next();
            if (!m2.isDeadOrEscaped()) {
                ++count;
                this.addToBot(new DamageAllEnemiesAction(p, damage , damageTypeForTurn, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
            }
        }
    }

    public void upp() {
        upgradeDamage(1);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(0);
    }
}