package code.patches;

import code.patches.subscribers.OnRefreshHandSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.Arrays;

@SuppressWarnings("unused")
public class RefreshHandPatch {

    @SpirePatch(clz = AbstractCard.class, method = "triggerOnRefreshHand")
    public static class onRefreshHand {

        @SpirePostfixPatch
        public static void postfix() {
            AbstractPlayer p = AbstractDungeon.player;

            for (AbstractPower power : p.powers) {
                if (power instanceof OnRefreshHandSubscriber) {
                    ((OnRefreshHandSubscriber) power).onRefreshHand();
                }
            }

            for (CardGroup cardGroup : Arrays.asList(p.hand, p.drawPile,
                    p.discardPile)) {
                for (AbstractCard card : cardGroup.group) {
                    if (card instanceof OnRefreshHandSubscriber) {
                        ((OnRefreshHandSubscriber) card).onRefreshHand();
                    }
                }
            }
        }
    }
}