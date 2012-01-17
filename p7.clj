;; Flatten a nested list structure.
;; Transform a list, possibly holding lists as elements into a `flat' list by replacing each list with its elements (recursively).

;; Example:
;; * (my-flatten '(a (b (c d) e)))
;; (A B C D E)

(defn my-flatten
  [coll]
  (when coll?
    (cond (empty? coll) '()
          (coll? (first coll)) (concat (my-flatten (first coll)) (my-flatten (rest coll)))
          :else (cons (first coll) (my-flatten (rest coll))))))
