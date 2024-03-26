package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import code.powers.LambdaPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_18 extends AbstractEasyCard {
    public final static String ID = makeID("ID_18");
    // intellij stuff POWER, SELF, UNCOMMON, 3, 1, 0, 0, 0, 0

    public ID_18() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LambdaPower(makeID("ID_18_Power"), AbstractPower.PowerType.BUFF, false, p, magicNumber) {
            @Override
            public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source)
            {
                if(target != p) return;
                if(power.ID != "PathToVictoryPower") return;

                this.addToBot(new DamageAllEnemiesAction(p, amount , DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
            }
        });
    }

    public void upp() {
        //upgradeDamage(1);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(0);
    }
}