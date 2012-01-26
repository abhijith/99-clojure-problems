;; Extract a given number of randomly selected elements from a list.
;; The selected items shall be returned in a list.
;; Example:
;; * (rnd-select '(a b c d e f g h) 3)
;; (E D A)

(defn rnd-select
  ([coll n len cnt acc]
     (cond (empty? coll) (seq acc)
           (= n cnt)     (seq acc)
           :else         (rnd-select coll n len (inc cnt) (conj acc (nth coll (rand-int len))))))
  ([coll n]
     (rnd-select coll n (count coll) 0 [])))
