package model.rank

import model.base.Score
import model.joker.Joker

/**
 * Represents an abstract base class for ranks categorized as even ranks.
 *
 * `EvenRank` extends the `Rank` trait and provides specific scoring logic
 * applicable to all even ranks. It utilizes the `Joker`'s `applyEven` method
 * to transform the given score accordingly.
 *
 * In the hierarchy of ranks, this class is typically extended by specific
 * even-ranked types such as Two, Four, or other even-valued ranks.
 *
 * @note The `applyScore` method of this class delegates the scoring logic
 *       to the `Joker`'s `applyEven` method.
 */
abstract class EvenRank extends Rank {
}
