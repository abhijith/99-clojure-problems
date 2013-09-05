;;  Group the elements of a set into disjoint subsets.
;; a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities and returns them in a list.

;; Example:
;; * (group3 '(aldo beat carla david evi flip gary hugo ida))
;; ( ( (ALDO BEAT) (CARLA DAVID EVI) (FLIP GARY HUGO IDA) )
;; ... )

;; b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.

;; Example:
;; * (group '(aldo beat carla david evi flip gary hugo ida) '(2 2 5))
;; ( ( (ALDO BEAT) (CARLA DAVID) (EVI FLIP GARY HUGO IDA) )
;; ... )

;; Note that we do not want permutations of the group members; i.e. ((ALDO BEAT) ...) is the same solution as ((BEAT ALDO) ...). However, we make a difference between ((ALDO BEAT) (CARLA DAVID) ...) and ((CARLA DAVID) (ALDO BEAT) ...).

;; You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".

(use '[clojure.set :only [difference]])

(defn groupn
  ([coll gs]
     (groupn coll coll gs (count gs) [] []))
  ([coll xs gs n-gs acc gacc]
     (let [n       (first gs)
           comb    (conj acc (first xs))
           ng-coll (into [] (sort (difference (set coll) (set comb))))]
       (cond (or (nil? xs) (empty? xs)) (when (= (count gacc) n-gs) (list gacc))
             (or (nil? gs) (empty? gs)) (when (= (count gacc) n-gs) (list gacc))
             :else   (concat (if (= (count comb) n)
                               (do #_(println (format "TRUE -> ng-coll: %s xs: %s COMB: %s n: %s coll: %s gacc: %s" ng-coll xs comb n coll gacc))
                                   (groupn ng-coll ng-coll (rest gs) n-gs [] (conj gacc comb)))
                               (do #_(println (format "\nFALSE -> ng-coll: %s xs: %s COMB: %s n: %s coll: %s gacc: %s" ng-coll xs comb n coll gacc))
                                   (groupn coll (rest xs) gs n-gs comb gacc)))
                             (groupn coll (rest xs) gs n-gs acc gacc))))))
