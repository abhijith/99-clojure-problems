;; Drop every N'th element from a list.
;; Example:
;; * (drop '(a b c d e f g h i k) 3)
;; (A B D E G H K)

(defn drop
  ([[f & r :as coll] n cnt acc]
     (cond (empty? coll)  acc
           (= cnt n)     (drop r n 1 acc)
           :else         (drop r n (inc cnt) (conj acc f))))
  ([coll n]
     (drop coll n 1 [])))
