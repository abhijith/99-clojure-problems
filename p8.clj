;; Eliminate consecutive duplicates of list elements.
;; If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

;; Example:
;; * (compress '(a a a a b c c a a d e e e e))
;; (A B C A D E)

(defn my-compress
  ([coll prev acc]
     (cond (empty? coll) (seq acc)
           (= prev (first coll)) (my-compress (rest coll) prev acc)
           :else (my-compress (rest coll) (first coll) (conj acc (first coll)))))
  ([coll]
     (my-compress coll :nil [])))
