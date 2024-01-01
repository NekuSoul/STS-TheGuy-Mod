package code.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;

public class Id7Card extends AbstractEasyCard {
    public final static String ID = makeID("Id7Card");
    // intellij stuff SKILL, PLAYER, RARE, 0, 0, 0, 0, 0, 0

    public Id7Card() {
        super(ID, -1, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
//        while(!p.hand.isEmpty())
            p.hand.moveToDiscardPile(p.hand.getRandomCard(false));

        if(upgraded)
            while (!p.drawPile.isEmpty())
                p.drawPile.moveToDiscardPile(p.drawPile.getTopCard());
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(0);
        upgradeBaseCost(-1);
    }
}