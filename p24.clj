;; Lotto: Draw N different random numbers from the set 1..M.
;; The selected numbers shall be returned in a list.
;; Example:
;; * (lotto-select 6 49)
;; (23 1 17 33 21 37)

;; Hint: Combine the solutions of problems P22 and P23.

(defn rnd-select
  ([coll n cnt acc]
     (let [ i (rand-int (count coll)) ]
       (cond (= n cnt)          (seq acc)
             (= (count coll) 1) (seq (conj acc (first coll)))
             :else              (rnd-select (remove-at coll i) n (inc cnt) (conj acc (nth coll i))))))
  ([coll n]
     (rnd-select coll n 0 [])))

(defn lotto-select
  [n max]
  (rnd-select (range 1 max) n))
