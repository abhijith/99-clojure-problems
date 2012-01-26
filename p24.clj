;; Lotto: Draw N different random numbers from the set 1..M.
;; The selected numbers shall be returned in a list.
;; Example:
;; * (lotto-select 6 49)
;; (23 1 17 33 21 37)

;; Hint: Combine the solutions of problems P22 and P23.

(defn rnd-select
  ([coll n len cnt acc]
     (cond (empty? coll) (seq acc)
           (= n cnt)     (seq acc)
           :else         (rnd-select coll n len (inc cnt) (conj acc (nth coll (rand-int len))))))
  ([coll n]
     (rnd-select coll n (count coll) 0 [])))

(defn lotto-select
  [n max]
  (rnd-select (range 1 max) n))
