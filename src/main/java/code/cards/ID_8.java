package code.cards;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

import static code.ModFile.makeID;

public class ID_8 extends AbstractEasyCard {
    public final static String ID = makeID("ID_8");
    // intellij stuff SKILL, PLAYER, COMMON, 0, 0, 0, 0, 0, 0

    public ID_8() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        //this.selfRetain = true;
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }
    @Override
    public void onRetained()
    {

    }
    @Override
    public void triggerOnEndOfTurnForPlayingCard()
    {
        this.retain = true;
        Iterator<AbstractCard> c = AbstractDungeon.player.hand.group.iterator();
        while(c.hasNext())
        {
            AbstractCard card = c.next();
            if(card.hasTag(CardTags.STARTER_DEFEND) || card.hasTag(CardTags.STARTER_STRIKE))
                card.retain = true;
        }
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DiscardAction(p, p, 3, false));
        addToBot(new DrawCardAction(magicNumber));
    }
    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        if(AbstractDungeon.player.hand.size() > 3)
            return true;
        return false;
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}