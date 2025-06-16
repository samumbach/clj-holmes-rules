(ns deprecated-desede
  (:import (java.util Base64)
           (javax.crypto Cipher)
           (javax.crypto.spec SecretKeySpec IvParameterSpec)))

(defn encrypt-vulnerable [data key iv]
  (let [cipher (Cipher/getInstance "desede/CBC/NoPadding")]
    (.init cipher Cipher/ENCRYPT_MODE (SecretKeySpec. key "DESede") (IvParameterSpec. iv))
    (.encodeToString (Base64/getEncoder) (.doFinal cipher data))))

(defn encrypt-not-vulnerable [data key iv]
  (let [cipher (Cipher/getInstance "AES/CBC/NoPadding")]
    (.init cipher Cipher/ENCRYPT_MODE (SecretKeySpec. key "AES") (IvParameterSpec. iv))
    (.encodeToString (Base64/getEncoder) (.doFinal cipher data))))
