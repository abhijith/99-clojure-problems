;; Split a list into two parts; the length of the first part is given.
;; Do not use any predefined predicates.

;; Example:
;; * (my-split '(a b c d e f g h i k) 3)
;; ( (A B C) (D E F G H I K))

(defn my-split
  ([[f & r :as coll] n cnt acc]
     (cond (empty? coll) (seq acc)
           (= n cnt)     (list (seq acc) r)
           :else         (my-split r n (inc cnt) (conj acc f))))
  ([coll n]
     (my-split coll n 1 [])))
