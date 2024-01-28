package code.cards;

import code.CharacterFile;
import code.cards.AbstractEasyCard;
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
        baseDamage = 3;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
        this.tags.add(CharacterFile.THEGUY_TAGS.Punch_THE_GUY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyPowers();
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

        if (!this.upgraded) {
            this.rawDescription = cardStrings.DESCRIPTION;
        } else {
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
        }

        this.initializeDescription();
    }

    public void applyPowers() {
        this.baseDamage = AbstractDungeon.player.discardPile.size();
        if (this.upgraded) {
            this.baseDamage += 3;
        }

        super.applyPowers();
        if (!this.upgraded) {
            this.rawDescription = "cardStrings.DESCRIPTION";
        } else {
            this.rawDescription = "cardStrings.UPGRADE_DESCRIPTION";
        }

        this.rawDescription = this.rawDescription + "cardStrings.EXTENDED_DESCRIPTION[0]";
        this.initializeDescription();
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(1);
    }
}