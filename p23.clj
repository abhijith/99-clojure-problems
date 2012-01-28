;; Extract a given number of randomly selected elements from a list.
;; The selected items shall be returned in a list.
;; Example:
;; * (rnd-select '(a b c d e f g h) 3)
;; (E D A)

(defn remove-at
  ([[f & r :as coll] n cnt acc]
     (cond (empty? coll) (seq acc)
           (= n cnt)     (remove-at r n (inc cnt) acc)
           :else         (remove-at r n (inc cnt) (conj acc f))))
  ([coll n]
     (remove-at coll n 0 [])))

(defn rnd-select
  ([coll n cnt acc]
     (let [ i (rand-int (count coll)) ]
       (cond (= n cnt)          (seq acc)
             (= (count coll) 1) (seq (conj acc (first coll)))
             :else              (rnd-select (remove-at coll i) n (inc cnt) (conj acc (nth coll i))))))
  ([coll n]
     (rnd-select coll n 0 [])))
