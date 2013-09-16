;; Check whether a given term represents a binary tree
;; Write a predicate istree which returns true if and only if its argument is a list representing a binary tree.
;; Example:
;; * (istree (a (b nil nil) nil))
;; T
;; * (istree (a (b nil nil)))
;; NIL

(defn root-node? [node]
  (not (or (nil? node) (coll? node))))

(defn node? [node]
  (if (coll? node) (tree? node) true))

(defn tree? [[root left right :as coll]]
  (cond (empty? coll)      true
        (= 3 (count coll)) (and (root-node? root)
                                (node? left)
                                (node? right))
        :else              false))
