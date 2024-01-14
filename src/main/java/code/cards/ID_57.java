package code.cards;

import code.CharacterFile;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.PummelDamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_57 extends AbstractEasyCard {
    public final static String ID = makeID("ID_57");
    // intellij stuff attack, enemy, uncommon, 4, 1, 0, 0, 4, 1

    public ID_57() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 4;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 4;
        exhaust = true;
        this.tags.add(CharacterFile.THEGUY_TAGS.Punch_THE_GUY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        for(int i = 1; i < this.magicNumber; ++i) {
            this.addToBot(new PummelDamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
        }

        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }

    public void upp() {
        upgradeDamage(1);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(2);
    }
}