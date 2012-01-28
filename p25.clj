;; Generate a random permutation of the elements of a list.
;; Example:
;; * (rnd-permu '(a b c d e f))
;; (B A D C E F)

(defn rnd-select
  ([coll n cnt acc]
     (let [ i (rand-int (count coll)) ]
       (cond (= n cnt)          (seq acc)
             (= (count coll) 1) (seq (conj acc (first coll)))
             :else              (rnd-select (remove-at coll i) n (inc cnt) (conj acc (nth coll i))))))
  ([coll n]
     (rnd-select coll n 0 [])))

(defn rnd-permu
  [coll]
  (rnd-select coll (count coll)))
