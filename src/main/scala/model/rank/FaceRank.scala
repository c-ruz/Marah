package model.rank

import model.base.Score
import model.joker.Joker

/**
 * Represents an abstract base class for ranks categorized as face ranks.
 *
 * `FaceRank` extends the `Rank` trait and provides specific scoring logic
 * applicable to all face ranks. It utilizes the `Joker`'s `applyFace` method
 * to transform the given score according to the rules defined for face ranks.
 *
 * In the hierarchy of ranks, this class is typically extended by specific
 * face-ranked types such as Jack, Queen, and King.
 *
 * @note The `applyScore` method of this class delegates the scoring logic
 *       to the `Joker`'s `applyFace` method.
 */
abstract class FaceRank extends Rank {
}
