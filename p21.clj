;; Insert an element at a given position into a list.
;; Example:
;; * (insert-at 'alfa '(a b c d) 2)
;; (A ALFA B C D)

(defn insert-at
  ([elem [f & r :as coll] n cnt acc]
     (cond (empty? coll) (seq acc)
           (= n cnt)     (insert-at elem r n (inc cnt) (conj acc elem f))
           :else         (insert-at elem r n (inc cnt) (conj acc f))))
  ([elem coll n]
     (insert-at elem coll n 1 [])))
