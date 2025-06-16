(ns weak-hash-function-sha1
  (:import (java.security MessageDigest)
           (org.apache.commons.codec.binary Hex)))

(defn hash-vulnerable [s]
  (let [md (MessageDigest/getInstance "SHA1")]
    (.update md (.getBytes s))
    (Hex/encodeHexString (.digest md))))

(defn hash-not-vulnerable [s]
  (let [md (MessageDigest/getInstance "SHA-512/256")]
    (.update md (.getBytes s))
    (Hex/encodeHexString (.digest md))))
