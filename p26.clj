;; Generate the combinations of K distinct objects chosen from the N elements of a list
;; In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficients). For pure mathematicians, this result may be great. But we want to really generate all the possibilities in a list.

;; Example:
;; * (combination 3 '(a b c d e f))
;; ((A B C) (A B D) (A B E) ... )

(defn window [coll n]
  (when (>= (count coll) n)
    (concat [(subvec coll 0 n)] (window (into [] (rest coll)) n))))

;; Example
;; (window [:a :b :c :d :e :f] 4)
;; ([:a :b :c :d] [:b :c :d :e] [:c :d :e :f])
