;; Find out whether a list is a palindrome.
;; A palindrome can be read forward or backward;
;; e.g. (x a m a x).

(defn palindrome
  [coll]
  (when-not (empty? coll)
    (let [cnt (count coll)
          half (int (/ cnt 2))
          even (even? cnt)
          pivot (if even half (inc half))]
      (loop [[f & r :as c] coll acc '() i 1]
        (if (= i pivot)
          (= (cons f acc) (if even r c))
          (recur r (cons f acc) (inc i)))))))
