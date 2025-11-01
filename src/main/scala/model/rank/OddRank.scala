package model.rank

import model.base.Score
import model.joker.Joker

/**
 * Represents an abstract base class for ranks categorized as odd ranks.
 *
 * `OddRank` extends the `Rank` trait and provides specific scoring logic
 * applicable to all odd ranks. It leverages the `Joker`'s `applyOdd` method
 * to transform the given score accordingly.
 *
 * In the hierarchy of ranks, this class is typically extended by specific
 * odd-ranked types such as Ace or other odd-valued ranks.
 *
 * @note The `applyScore` method of this class delegates the scoring logic
 *       to the `Joker`'s `applyOdd` method.
 */
abstract class OddRank extends Rank {
}
