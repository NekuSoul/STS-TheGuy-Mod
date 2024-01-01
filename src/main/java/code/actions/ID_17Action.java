package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.Iterator;

public class ID_17Action extends AbstractGameAction {

    int damage;
    AbstractMonster m;
    AbstractPlayer p;
    DamageInfo.DamageType damageTypeForTurn;

    public ID_17Action(AbstractPlayer p, AbstractMonster m, int damage , DamageInfo.DamageType damageTypeForTurn)
    {
        this.p = p;
        this.damage = damage;
        this.m = m;
        this.damageTypeForTurn = damageTypeForTurn;
    }
    @Override
    public void update()
    {
        Iterator<AbstractPower> var2 = p.powers.iterator();
        AbstractPower ap = null;
        do {
            if (!var2.hasNext()) {
                break;
            }
            ap = (AbstractPower)var2.next();
        } while(!ap.ID.equals("PathToVictoryPower"));
        int cnt = 0;
        if(ap != null)
            cnt += ap.amount;
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage * cnt, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        this.isDone = true;
    }
}
