;; Generate a random permutation of the elements of a list.
;; Example:
;; * (rnd-permu '(a b c d e f))
;; (B A D C E F)

(defn rnd-select
  ([coll n len cnt acc]
     (cond (empty? coll) (seq acc)
           (= n cnt)     (seq acc)
           :else         (rnd-select coll n len (inc cnt) (conj acc (nth coll (rand-int len))))))
  ([coll n]
     (rnd-select coll n (count coll) 0 [])))

(defn rnd-permu
  [coll]
  (rnd-select coll (count coll)))
