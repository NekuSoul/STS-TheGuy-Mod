package code.powers;

import code.patches.subscribers.OnManualDiscardSubscriber;
import com.megacrit.cardcrawl.core.AbstractCreature;

public abstract class LambdaPower extends AbstractEasyPower {
    public LambdaPower(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, powerType, isTurnBased, owner, amount);
    }

    public void onManualDiscard(){}
    public void onRefreshHand(){}
    public abstract void updateDescription();
}
