;; Generate a random permutation of the elements of a list.
;; Example:
;; * (rnd-permu '(a b c d e f))
;; (B A D C E F)

(defn remove-at
  ([[f & r :as coll] n cnt acc]
     (cond (empty? coll) (seq acc)
           (= n cnt)     (remove-at r n (inc cnt) acc)
           :else         (remove-at r n (inc cnt) (conj acc f))))
  ([coll n]
     (remove-at coll n 0 [])))

(defn rnd-permu
  ([coll acc]
     (let [ n (rand-int (count coll)) ]
       (cond (empty? coll)      (seq acc)
             (= (count coll) 1) (seq (conj acc (first coll)))
             :else              (rnd-permu (remove-at coll n) (conj acc (nth coll n))))))
  ([coll]
     (rnd-permu coll [])))
