;; Sorting a list of lists according to length of sublists
;; a) We suppose that a list contains elements that are lists themselves. The objective is to sort the elements of this list according to their length. E.g. short lists first, longer lists later, or vice versa.

;; Example:
;; * (lsort '((a b c) (d e) (f g h) (d e) (i j k l) (m n) (o)))
;; ((O) (D E) (D E) (M N) (A B C) (F G H) (I J K L))

;; b) Again, we suppose that a list contains elements that are lists themselves. But this time the objective is to sort the elements of this list according to their length frequency; i.e., in the default, where sorting is done ascendingly, lists with rare lengths are placed first, others with a more frequent length come later.

;; Example:
;; * (lfsort '((a b c) (d e) (f g h) (d e) (i j k l) (m n) (o)))
;; ((i j k l) (o) (a b c) (f g h) (d e) (d e) (m n))

;; Note that in the above example, the first two lists in the result have length 4 and 1, both lengths appear just once. The third and forth list have length 3 which appears twice (there are two list of this length). And finally, the last three lists have length 2. This is the most frequent length.

(defn sorter
  ([coll lambda f]
     (sorter coll lambda (count coll) 1 [] []))
  ([coll lambda n i xs sorted]
     (if-not (> i n)
       (let [a (first coll) b (second coll) rst (drop 2 coll)]
         (cond (empty? (rest coll)) (sorter xs lambda n (inc i) [] (cons a sorted))
               (lambda a b)         (sorter (concat [a] rst) lambda n i (conj xs b) sorted)
               :else                (sorter (rest coll) lambda n i (conj xs a) sorted)))
       sorted)))

(defn lsort [coll]
  (sorter coll (fn [a b] (> (count a) (count b)))))

(defn length-freqs
  ([coll] (length-freqs coll {}))
  ([coll acc]
     (if (empty? coll)
       acc
       (let [[f & r] coll n (count f)]
         (length-freqs r (update-in acc [n] #(if (nil? %1) 1 (inc %1))))))))

(defn lfsort [coll]
  (let [freqs (length-freqs coll)]
    (sorter coll (fn [a b] (> (freqs (count a)) (freqs (count b)))))))
