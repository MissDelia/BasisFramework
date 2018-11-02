#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_iwhalecloud_mobile_basisframework_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "用户信息";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_iwhalecloud_mobile_basisframework_app_util_SecretUtil_encrypt(JNIEnv *env, jclass type,
                                                                       jstring input_,
                                                                       jstring key_) {
    const char *input = env->GetStringUTFChars(input_, 0);
    const char *key = env->GetStringUTFChars(key_, 0);

    // TODO

    env->ReleaseStringUTFChars(input_, input);
    env->ReleaseStringUTFChars(key_, key);

    return env->NewStringUTF("");
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_iwhalecloud_mobile_basisframework_app_util_SecretUtil_decrypt(JNIEnv *env, jclass type,
                                                                       jstring input_,
                                                                       jstring key_) {
    const char *input = env->GetStringUTFChars(input_, 0);
    const char *key = env->GetStringUTFChars(key_, 0);

    // TODO

    env->ReleaseStringUTFChars(input_, input);
    env->ReleaseStringUTFChars(key_, key);

    return env->NewStringUTF("");
}