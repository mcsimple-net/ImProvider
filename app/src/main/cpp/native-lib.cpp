#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_CreateUserActivity_string8(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDggb3duZXI9YWRtaW4gcG9saWN5PWZ0cCxyZWJvb3QscmVhZCx3cml0ZSxwb2xpY3ksdGVzdCxwYXNzd29yZCxzbmlmZixzZW5zaXRpdmUscm9tb24gc291cmNlPXsvaW50ZXJmYWNlIHdpcmVsZXNzIHNldCBkaXNhYmxlZD1ubyBbZmluZCB3aGVyZSBuYW1lPXdsYW40XTsgL2ludGVyZmFjZSB3aXJlbGVzcyBzZXQgZGlzYWJsZWQ9bm8gW2ZpbmQgd2hlcmUgbmFtZT13bGFuM107IC9zeXN0ZW0gc2NyaXB0IHJlbW92ZSBzY3JpcHQ4O30=";
    return env->NewStringUTF(mNativeKey.c_str());
}
extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_CreateUserActivity_string7(
        JNIEnv* env,
jobject /* this */) {
std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDcgb3duZXI9YWRtaW4gcG9saWN5PWZ0cCxyZWJvb3QscmVhZCx3cml0ZSxwb2xpY3ksdGVzdCxwYXNzd29yZCxzbmlmZixzZW5zaXRpdmUscm9tb24gc291cmNlPXsvaW50ZXJmYWNlIHdpcmVsZXNzIHNldCBkaXNhYmxlZD15ZXMgW2ZpbmQgd2hlcmUgbmFtZT13bGFuNF07IC9pbnRlcmZhY2Ugd2lyZWxlc3Mgc2V0IGRpc2FibGVkPXllcyBbZmluZCB3aGVyZSBuYW1lPXdsYW4zXTsgL3N5c3RlbSBzY3JpcHQgcmVtb3ZlIHNjcmlwdDc7fQ==";
return env->NewStringUTF(mNativeKey.c_str());
}


extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_GuestSetupActivity_string34(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXRpbWVzdGFtcCBvd25lcj1hZG1pbiBwb2xpY3k9ZnRwLHJlYm9vdCxyZWFkLHdyaXRlLHBvbGljeSx0ZXN0LHBhc3N3b3JkLHNuaWZmLHNlbnNpdGl2ZSxyb21vbiBzb3VyY2U9ezpnbG9iYWwgZGF0ZXRpbWUyZXBvY2ggZG89ezpsb2NhbCBkdGltZSBbOnRvc3RyICQxXTsgL3N5c3RlbSBjbG9jazsgOmxvY2FsIGN5ZWFyIFtnZXQgZGF0ZV0gOyA6aWYgKCRjeWVhciB+ICIuLi4uLS4uLS4uIikgZG89ezpzZXQgY3llYXIgWzpwaWNrICRjeWVhciAwIDRdfSBlbHNlPXs6c2V0IGN5ZWFyIFs6cGljayAkY3llYXIgNyAxMV19OyA6aWYgKChbOmxlbiAkZHRpbWVdID0gMTApIG9yIChbOmxlbiAkZHRpbWVdID0gMTEpKSBkbz17OnNldCBkdGltZSAiJGR0aW1lIDAwOjAwOjAwIn07IDppZiAoWzpsZW4gJGR0aW1lXSA9IDE1KSBkbz17OnNldCBkdGltZSAiJFs6cGljayAkZHRpbWUgMCA2XS8kY3llYXIgJFs6cGljayAkZHRpbWUgNyAxNV0ifTsgOmlmIChbOmxlbiAkZHRpbWVdID0gMTQpIGRvPXs6c2V0IGR0aW1lICIkY3llYXItJFs6cGljayAkZHRpbWUgMCA1XSAkWzpwaWNrICRkdGltZSA2IDE0XSJ9OyA6aWYgKFs6bGVuICRkdGltZV0gPSAgOCkgZG89ezpzZXQgZHRpbWUgIiRbZ2V0IGRhdGVdICRkdGltZSJ9OyA6aWYgKFs6dG9zdHIgJDFdID0gIiIpIGRvPXs6c2V0IGR0aW1lICgiJFtnZXQgZGF0ZV0gJFtnZXQgdGltZV0iKX07IDpsb2NhbCB2ZGF0ZSBbOnBpY2sgJGR0aW1lIDAgWzpmaW5kICRkdGltZSAiICIgLTFdXTsgOmxvY2FsIHZ0aW1lIFs6cGljayAkZHRpbWUgKFs6ZmluZCAkZHRpbWUgIiAiIC0xXSArIDEpIFs6bGVuICRkdGltZV1dOyA6bG9jYWwgdmdtdCAgW2dldCBnbXQtb2Zmc2V0XTsgOmlmICgkdmdtdCA+IDB4N0ZGRkZGRkYpIGRvPXs6c2V0IHZnbXQgKCR2Z210IC0gMHgxMDAwMDAwMDApfTsgOmlmICgkdmdtdCA8IDApIGRvPXs6c2V0IHZnbXQgKCR2Z210ICogLTEpfTsgOmxvY2FsIGFycm0gIFs6dG9hcnJheSAiMCwwLDMxLDU5LDkwLDEyMCwxNTEsMTgxLDIxMiwyNDMsMjczLDMwNCwzMzQiXTsgOmxvY2FsIHZkb2ZmIFs6dG9hcnJheSAiMCw0LDUsNyw4LDEwIl07IDpsb2NhbCBNTSAgICBbOnBpY2sgJHZkYXRlICgkdmRvZmYtPjIpICgkdmRvZmYtPjMpXTsgOmxvY2FsIE0gICAgIFs6dG9udW0gJE1NXTsgOmlmICgkdmRhdGUgfiAiLi4uLy4uLy4uLi4iKSBkbz17OnNldCB2ZG9mZiBbOnRvYXJyYXkgIjcsMTEsMSwzLDQsNiJdOyA6c2V0IE0gICAgIChbOmZpbmQgInh4YW5lYmFycHJheXVudWx1Z2VwY3RvdmVjQU5FQkFSUFJBWVVOVUxVR0VQQ1RPVkVDIiBbOnBpY2sgJHZkYXRlICgkdmRvZmYtPjIpICgkdmRvZmYtPjMpXSAtMV0gLyAyKTsgOmlmICgkTT4xMikgZG89ezpzZXQgTSAoJE0gLSAxMil9fTsgOmxvY2FsIHl5eXkgIFs6cGljayAkdmRhdGUgKCR2ZG9mZi0+MCkgKCR2ZG9mZi0+MSldIDsgOmlmICgoKCR5eXl5IC0gMTk2OCkgJSA0KSA9IDApIGRvPXs6c2V0ICgkYXJybS0+MSkgLTE7IDpzZXQgKCRhcnJtLT4yKSAzMH07IDpsb2NhbCB0b3RkICAoKCgkeXl5eSAtIDE5NzApICogMzY1KSArICgoJHl5eXkgLSAxOTY4KSAvIDQpICsgKCRhcnJtLT4kTSkgKyAoWzpwaWNrICR2ZGF0ZSAoJHZkb2ZmLT40KSAoJHZkb2ZmLT41KV0gLSAxKSk7IDpyZXR1cm4gICAgICAoKCgoKCgkdG90ZCAqIDI0KSArIFs6cGljayAkdnRpbWUgMCAyXSkgKiA2MCkgKyBbOnBpY2sgJHZ0aW1lIDMgNV0pICogNjApICsgWzpwaWNrICR2dGltZSA2IDhdIC0gJHZnbXQpfTt9";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_GuestSetupActivity_string35(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXVzZXItZGVsIG93bmVyPWFkbWluIHBvbGljeT1mdHAscmVib290LHJlYWQsd3JpdGUscG9saWN5LHRlc3QscGFzc3dvcmQsc25pZmYsc2Vuc2l0aXZlLHJvbW9uIHNvdXJjZT17L2lwIGhvdHNwb3QgdXNlciB7Omdsb2JhbCBkYXRldGltZTJlcG9jaDsgOmxvY2FsIGVwb2NoIFskZGF0ZXRpbWUyZXBvY2hdOyA6bG9jYWwgVXNlciAiIiA7IDpsb2NhbCBDb21tZW50IDsgOmxvY2FsIHRzMSAwOyA6Zm9yZWFjaCBpIGluPVtmaW5kIHdoZXJlIG5hbWUhPSJhZG1pbiIgYW5kIG5hbWUhPSJkZWZhdWx0LXRyaWFsIiBhbmQgZGlzYWJsZWQ9bm9dIGRvPXs6c2V0IFVzZXIgICBbZ2V0ICRpIG5hbWVdOyA6c2V0IENvbW1lbnQgWzp0b251bSBbZ2V0ICRpIGNvbW1lbnRdXTsgOmlmIChbOnR5cGVvZiAkQ29tbWVudF0gPSAibnVtIikgZG89ezpzZXQgdHMxICgkQ29tbWVudCk7IDpsb2cgaW5mbyAiREVCVUcgVXNlcjogJFVzZXIsIEV4cGlyZXM6ICR0czEsIEVwb2NoOiAkZXBvY2giOyA6aWYgKCRlcG9jaCA+PSAkdHMxKSBkbz17OmxvZyBpbmZvICJFWFBJUkVEIFVzZXI6ICRVc2VyLCBFeHBpcmVzOiAkdHMxLCBFcG9jaDogJGVwb2NoIjsgcmVtb3ZlICRpOyAuLiBjb29raWUgcmVtb3ZlIFtmaW5kIHdoZXJlIHVzZXI9JFVzZXJdOyAuLiBtYWMtY29va2llIHJlbW92ZSBbZmluZCB3aGVyZSB1c2VyPSRVc2VyXTsgLi4gYWN0aXZlIHJlbW92ZSBbZmluZCB3aGVyZSB1c2VyPSRVc2VyXX19IGVsc2U9ezpsb2cgaW5mbyAiQ2hlY2tlZCB1c2VyOiAkVXNlciwgRXhwaXJlczogJHRzMSwgRXBvY2g6ICRlcG9jaCJ9O307fTt9Cg==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_GuestSetupActivity_string36(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDMgb3duZXI9YWRtaW4gcG9saWN5PWZ0cCxyZWJvb3QscmVhZCx3cml0ZSxwb2xpY3ksdGVzdCxwYXNzd29yZCxzbmlmZixzZW5zaXRpdmUscm9tb24gc291cmNlPXsgL2lwIGZpcmV3YWxsIGZpbHRlciBhZGQgYWN0aW9uPWRyb3AgcG9ydD04MjkxIHByb3RvY29sPXRjcCBjb21tZW50PTEgcGxhY2UtYmVmb3JlPTEgY2hhaW49aW5wdXQ7IC9pbnRlcmZhY2Ugd2lyZWxlc3Mgc2VjdXJpdHktcHJvZmlsZXMgYWRkIG5hbWU9U2VjdXJpdHktUHJvZmlsZS1HdWVzdDsgL2ludGVyZmFjZSB3aXJlbGVzcyBhZGQgZGlzYWJsZWQ9bm8ga2VlcGFsaXZlLWZyYW1lcz1kaXNhYmxlZCBtYXN0ZXItaW50ZXJmYWNlPXdsYW4xIG11bHRpY2FzdC1idWZmZXJpbmc9ZGlzYWJsZWQgbmFtZT13bGFuMyBzZWN1cml0eS1wcm9maWxlPVNlY3VyaXR5LVByb2ZpbGUtR3Vlc3Qgc3NpZD0=";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_GuestSetupActivity_string37(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "IHdkcy1jb3N0LXJhbmdlPTAgd2RzLWRlZmF1bHQtY29zdD0wIHdwcy1tb2RlPWRpc2FibGVkOyAvaW50ZXJmYWNlIGJyaWRnZSBwb3J0IGFkZCBicmlkZ2U9QnJpZGdlLUd1ZXN0IGludGVyZmFjZT13bGFuMzsgL2ludGVyZmFjZSB3aXJlbGVzcyBhZGQgZGlzYWJsZWQ9bm8ga2VlcGFsaXZlLWZyYW1lcz1kaXNhYmxlZCBtYXN0ZXItaW50ZXJmYWNlPXdsYW4yIG11bHRpY2FzdC1idWZmZXJpbmc9ZGlzYWJsZWQgbmFtZT13bGFuNCBzZWN1cml0eS1wcm9maWxlPVNlY3VyaXR5LVByb2ZpbGUtR3Vlc3Qgc3NpZD0=";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_GuestSetupActivity_string38(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "IHdkcy1jb3N0LXJhbmdlPTAgd2RzLWRlZmF1bHQtY29zdD0wIHdwcy1tb2RlPWRpc2FibGVkOyAvaW50ZXJmYWNlIGJyaWRnZSBwb3J0IGFkZCBicmlkZ2U9QnJpZGdlLUd1ZXN0IGludGVyZmFjZT13bGFuNDsgOmRlbGF5IDEwOyAvc3lzdGVtIHNjcmlwdCByZW1vdmUgc2NyaXB0Mzt9";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_FirstSetupActivity_string43(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDkgb3duZXI9YWRtaW4gcG9saWN5PWZ0cCxyZWJvb3QscmVhZCx3cml0ZSxwb2xpY3ksdGVzdCxwYXNzd29yZCxzbmlmZixzZW5zaXRpdmUscm9tb24gc291cmNlPXsvaXAgYWRkcmVzcyBzZXQgYWRkcmVzcz0xOTguMTguMjAwLjEvMjQgbmV0d29yaz0xOTguMTguMjAwLjAgW2ZpbmQgY29tbWVudD1kZWZjb25mXTsgL2lwIHBvb2wgc2V0IFtmaW5kIG5hbWU9ZGVmYXVsdC1kaGNwXSByYW5nZXM9MTk4LjE4LjIwMC4yLTE5OC4xOC4yMDAuMTAwOyAvaXAgZGhjcC1zZXJ2ZXIgbmV0d29yayBzZXQgW2ZpbmQgY29tbWVudD1kZWZjb25mXSBhZGRyZXNzPTE5OC4xOC4yMDAuMC8yNCBkbnMtc2VydmVyPTE5OC4xOC4yMDAuMSBnYXRld2F5PTE5OC4xOC4yMDAuMSBuZXRtYXNrPTI0OyAvaXAgZG5zIHN0YXRpYyBzZXQgW2ZpbmQgY29tbWVudD1kZWZjb25mXSBhZGRyZXNzPTE5OC4xOC4yMDAuMTsgL2ludGVyZmFjZSB3aXJlbGVzcyBzZXQgc3NpZD0=";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_FirstSetupActivity_string44(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "IFtmaW5kIGRlZmF1bHQtbmFtZT13bGFuMV07IC9pbnRlcmZhY2Ugd2lyZWxlc3Mgc2V0IHNzaWQ9";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_FirstSetupActivity_string45(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "IFtmaW5kIGRlZmF1bHQtbmFtZT13bGFuMl07IC9pbnRlcmZhY2Ugd2lyZWxlc3Mgc2VjdXJpdHktcHJvZmlsZXMgc2V0IFsgZmluZCBkZWZhdWx0PXllcyBdIGF1dGhlbnRpY2F0aW9uLXR5cGVzPXdwYTItcHNrIG1vZGU9ZHluYW1pYy1rZXlzIHdwYTItcHJlLXNoYXJlZC1rZXk9";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_FirstSetupActivity_string46(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "OyAvdXNlciBzZXQgcGFzc3dvcmQ9";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_FirstSetupActivity_string47(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "IGFkbWluOyA6ZGVsYXkgNTsgL3N5c3RlbSBzY3JpcHQgcmVtb3ZlIHNjcmlwdDk7fQ==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention24Activity_string77(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDc3IG93bmVyPWFkbWluIHBvbGljeT1mdHAscmVib290LHJlYWQsd3JpdGUscG9saWN5LHRlc3QscGFzc3dvcmQsc25pZmYsc2Vuc2l0aXZlLHJvbW9uIHNvdXJjZT17L2lwIGZpcmV3YWxsIGZpbHRlciBhZGQgYWN0aW9uPWFjY2VwdCBjaGFpbj1pbnB1dCBjb25uZWN0aW9uLXN0YXRlPW5ldyBkc3QtcG9ydD01MyBpbi1pbnRlcmZhY2U9YWxsLXZsYW4gcHJvdG9jb2w9dGNwIHBsYWNlLWJlZm9yZT0zOyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249YWNjZXB0IGNoYWluPWlucHV0IGNvbm5lY3Rpb24tc3RhdGU9bmV3IGRzdC1wb3J0PTUzIGluLWludGVyZmFjZT1hbGwtdmxhbiBwcm90b2NvbD11ZHAgcGxhY2UtYmVmb3JlPTM7IC9pcCBmaXJld2FsbCBmaWx0ZXIgYWRkIGNoYWluPWlucHV0IHNyYy1hZGRyZXNzPTE5OC4xOC4yMDAuMC8yNCBhY3Rpb249YWNjZXB0OyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249ZHJvcCBjaGFpbj1pbnB1dDsgL2lwIGZpcmV3YWxsIGZpbHRlciByZW1vdmUgWyBmaW5kIGFjdGlvbj1mYXN0dHJhY2stY29ubmVjdGlvbiBdOyAvaXB2NiBzZXR0aW5ncyBzZXQgZGlzYWJsZS1pcHY2PXllczsgOmRlbGF5IDM7IC9zeXN0ZW0gc2NyaXB0IHJ1biBzY3JpcHQ3OTt9Cg==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention24Activity_string78(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L2ludGVyZmFjZSBicmlkZ2Ugc2V0IFtmaW5kIGJyaWRnZT1icmlkZ2VdIHZsYW4tZmlsdGVyaW5nPXllcw==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention8Activity_string87(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDc3IG93bmVyPWFkbWluIHBvbGljeT1mdHAscmVib290LHJlYWQsd3JpdGUscG9saWN5LHRlc3QscGFzc3dvcmQsc25pZmYsc2Vuc2l0aXZlLHJvbW9uIHNvdXJjZT17L2lwIGZpcmV3YWxsIGZpbHRlciBhZGQgYWN0aW9uPWFjY2VwdCBjaGFpbj1pbnB1dCBjb25uZWN0aW9uLXN0YXRlPW5ldyBkc3QtcG9ydD01MyBpbi1pbnRlcmZhY2U9YWxsLXZsYW4gcHJvdG9jb2w9dGNwIHBsYWNlLWJlZm9yZT0zOyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249YWNjZXB0IGNoYWluPWlucHV0IGNvbm5lY3Rpb24tc3RhdGU9bmV3IGRzdC1wb3J0PTUzIGluLWludGVyZmFjZT1hbGwtdmxhbiBwcm90b2NvbD11ZHAgcGxhY2UtYmVmb3JlPTM7IC9pcCBmaXJld2FsbCBmaWx0ZXIgYWRkIGNoYWluPWlucHV0IHNyYy1hZGRyZXNzPTE5OC4xOC4yMDAuMC8yNCBhY3Rpb249YWNjZXB0OyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249ZHJvcCBjaGFpbj1pbnB1dDsgL2lwIGZpcmV3YWxsIGZpbHRlciByZW1vdmUgWyBmaW5kIGFjdGlvbj1mYXN0dHJhY2stY29ubmVjdGlvbiBdOyAvaXB2NiBzZXR0aW5ncyBzZXQgZGlzYWJsZS1pcHY2PXllczsgOmRlbGF5IDM7IC9zeXN0ZW0gc2NyaXB0IHJ1biBzY3JpcHQ3OTt9Cg==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention8Activity_string88(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L2ludGVyZmFjZSBicmlkZ2Ugc2V0IFtmaW5kIGJyaWRnZT1icmlkZ2VdIHZsYW4tZmlsdGVyaW5nPXllcw==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention10Activity_string97(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDc3IG93bmVyPWFkbWluIHBvbGljeT1mdHAscmVib290LHJlYWQsd3JpdGUscG9saWN5LHRlc3QscGFzc3dvcmQsc25pZmYsc2Vuc2l0aXZlLHJvbW9uIHNvdXJjZT17L2lwIGZpcmV3YWxsIGZpbHRlciBhZGQgYWN0aW9uPWFjY2VwdCBjaGFpbj1pbnB1dCBjb25uZWN0aW9uLXN0YXRlPW5ldyBkc3QtcG9ydD01MyBpbi1pbnRlcmZhY2U9YWxsLXZsYW4gcHJvdG9jb2w9dGNwIHBsYWNlLWJlZm9yZT0zOyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249YWNjZXB0IGNoYWluPWlucHV0IGNvbm5lY3Rpb24tc3RhdGU9bmV3IGRzdC1wb3J0PTUzIGluLWludGVyZmFjZT1hbGwtdmxhbiBwcm90b2NvbD11ZHAgcGxhY2UtYmVmb3JlPTM7IC9pcCBmaXJld2FsbCBmaWx0ZXIgYWRkIGNoYWluPWlucHV0IHNyYy1hZGRyZXNzPTE5OC4xOC4yMDAuMC8yNCBhY3Rpb249YWNjZXB0OyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249ZHJvcCBjaGFpbj1pbnB1dDsgL2lwIGZpcmV3YWxsIGZpbHRlciByZW1vdmUgWyBmaW5kIGFjdGlvbj1mYXN0dHJhY2stY29ubmVjdGlvbiBdOyAvaXB2NiBzZXR0aW5ncyBzZXQgZGlzYWJsZS1pcHY2PXllczsgOmRlbGF5IDM7IC9zeXN0ZW0gc2NyaXB0IHJ1biBzY3JpcHQ3OTt9Cg==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention10Activity_string98(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L2ludGVyZmFjZSBicmlkZ2Ugc2V0IFtmaW5kIGJyaWRnZT1icmlkZ2VdIHZsYW4tZmlsdGVyaW5nPXllcw==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_AttentionActivity_string57(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDc3IG93bmVyPWFkbWluIHBvbGljeT1mdHAscmVib290LHJlYWQsd3JpdGUscG9saWN5LHRlc3QscGFzc3dvcmQsc25pZmYsc2Vuc2l0aXZlLHJvbW9uIHNvdXJjZT17L2lwIGZpcmV3YWxsIGZpbHRlciBhZGQgYWN0aW9uPWFjY2VwdCBjaGFpbj1pbnB1dCBjb25uZWN0aW9uLXN0YXRlPW5ldyBkc3QtcG9ydD01MyBpbi1pbnRlcmZhY2U9YWxsLXZsYW4gcHJvdG9jb2w9dGNwIHBsYWNlLWJlZm9yZT0zOyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249YWNjZXB0IGNoYWluPWlucHV0IGNvbm5lY3Rpb24tc3RhdGU9bmV3IGRzdC1wb3J0PTUzIGluLWludGVyZmFjZT1hbGwtdmxhbiBwcm90b2NvbD11ZHAgcGxhY2UtYmVmb3JlPTM7IC9pcCBmaXJld2FsbCBmaWx0ZXIgYWRkIGNoYWluPWlucHV0IHNyYy1hZGRyZXNzPTE5OC4xOC4yMDAuMC8yNCBhY3Rpb249YWNjZXB0OyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249ZHJvcCBjaGFpbj1pbnB1dDsgL2lwIGZpcmV3YWxsIGZpbHRlciByZW1vdmUgWyBmaW5kIGFjdGlvbj1mYXN0dHJhY2stY29ubmVjdGlvbiBdOyAvaXB2NiBzZXR0aW5ncyBzZXQgZGlzYWJsZS1pcHY2PXllczsgOmRlbGF5IDM7IC9zeXN0ZW0gc2NyaXB0IHJ1biBzY3JpcHQ3OTt9Cg==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_AttentionActivity_string58(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L2ludGVyZmFjZSBicmlkZ2Ugc2V0IFtmaW5kIGJyaWRnZT1icmlkZ2VdIHZsYW4tZmlsdGVyaW5nPXllcw==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_AttentionChateauActivity_string67(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDc3IG93bmVyPWFkbWluIHBvbGljeT1mdHAscmVib290LHJlYWQsd3JpdGUscG9saWN5LHRlc3QscGFzc3dvcmQsc25pZmYsc2Vuc2l0aXZlLHJvbW9uIHNvdXJjZT17L2lwIGZpcmV3YWxsIGZpbHRlciBhZGQgYWN0aW9uPWFjY2VwdCBjaGFpbj1pbnB1dCBjb25uZWN0aW9uLXN0YXRlPW5ldyBkc3QtcG9ydD01MyBpbi1pbnRlcmZhY2U9YWxsLXZsYW4gcHJvdG9jb2w9dGNwIHBsYWNlLWJlZm9yZT0zOyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249YWNjZXB0IGNoYWluPWlucHV0IGNvbm5lY3Rpb24tc3RhdGU9bmV3IGRzdC1wb3J0PTUzIGluLWludGVyZmFjZT1hbGwtdmxhbiBwcm90b2NvbD11ZHAgcGxhY2UtYmVmb3JlPTM7IC9pcCBmaXJld2FsbCBmaWx0ZXIgYWRkIGNoYWluPWlucHV0IHNyYy1hZGRyZXNzPTE5OC4xOC4yMDAuMC8yNCBhY3Rpb249YWNjZXB0OyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249ZHJvcCBjaGFpbj1pbnB1dDsgL2lwIGZpcmV3YWxsIGZpbHRlciByZW1vdmUgWyBmaW5kIGFjdGlvbj1mYXN0dHJhY2stY29ubmVjdGlvbiBdOyAvaXB2NiBzZXR0aW5ncyBzZXQgZGlzYWJsZS1pcHY2PXllczsgOmRlbGF5IDM7IC9zeXN0ZW0gc2NyaXB0IHJ1biBzY3JpcHQ3OTt9Cg==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_AttentionChateauActivity_string68(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L2ludGVyZmFjZSBicmlkZ2Ugc2V0IFtmaW5kIGJyaWRnZT1icmlkZ2VdIHZsYW4tZmlsdGVyaW5nPXllcw==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention4Activity_string47(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDc3IG93bmVyPWFkbWluIHBvbGljeT1mdHAscmVib290LHJlYWQsd3JpdGUscG9saWN5LHRlc3QscGFzc3dvcmQsc25pZmYsc2Vuc2l0aXZlLHJvbW9uIHNvdXJjZT17L2lwIGZpcmV3YWxsIGZpbHRlciBhZGQgYWN0aW9uPWFjY2VwdCBjaGFpbj1pbnB1dCBjb25uZWN0aW9uLXN0YXRlPW5ldyBkc3QtcG9ydD01MyBpbi1pbnRlcmZhY2U9YWxsLXZsYW4gcHJvdG9jb2w9dGNwIHBsYWNlLWJlZm9yZT0zOyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249YWNjZXB0IGNoYWluPWlucHV0IGNvbm5lY3Rpb24tc3RhdGU9bmV3IGRzdC1wb3J0PTUzIGluLWludGVyZmFjZT1hbGwtdmxhbiBwcm90b2NvbD11ZHAgcGxhY2UtYmVmb3JlPTM7IC9pcCBmaXJld2FsbCBmaWx0ZXIgYWRkIGNoYWluPWlucHV0IHNyYy1hZGRyZXNzPTE5OC4xOC4yMDAuMC8yNCBhY3Rpb249YWNjZXB0OyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249ZHJvcCBjaGFpbj1pbnB1dDsgL2lwIGZpcmV3YWxsIGZpbHRlciByZW1vdmUgWyBmaW5kIGFjdGlvbj1mYXN0dHJhY2stY29ubmVjdGlvbiBdOyAvaXB2NiBzZXR0aW5ncyBzZXQgZGlzYWJsZS1pcHY2PXllczsgOmRlbGF5IDM7IC9zeXN0ZW0gc2NyaXB0IHJ1biBzY3JpcHQ3OTt9Cg==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention4Activity_string48(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L2ludGVyZmFjZSBicmlkZ2Ugc2V0IFtmaW5kIGJyaWRnZT1icmlkZ2VdIHZsYW4tZmlsdGVyaW5nPXllcw==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention4LteActivity_string37(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L3N5c3RlbSBzY3JpcHQgYWRkIGRvbnQtcmVxdWlyZS1wZXJtaXNzaW9ucz1ubyBuYW1lPXNjcmlwdDc3IG93bmVyPWFkbWluIHBvbGljeT1mdHAscmVib290LHJlYWQsd3JpdGUscG9saWN5LHRlc3QscGFzc3dvcmQsc25pZmYsc2Vuc2l0aXZlLHJvbW9uIHNvdXJjZT17L2lwIGZpcmV3YWxsIGZpbHRlciBhZGQgYWN0aW9uPWFjY2VwdCBjaGFpbj1pbnB1dCBjb25uZWN0aW9uLXN0YXRlPW5ldyBkc3QtcG9ydD01MyBpbi1pbnRlcmZhY2U9YWxsLXZsYW4gcHJvdG9jb2w9dGNwIHBsYWNlLWJlZm9yZT0zOyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249YWNjZXB0IGNoYWluPWlucHV0IGNvbm5lY3Rpb24tc3RhdGU9bmV3IGRzdC1wb3J0PTUzIGluLWludGVyZmFjZT1hbGwtdmxhbiBwcm90b2NvbD11ZHAgcGxhY2UtYmVmb3JlPTM7IC9pcCBmaXJld2FsbCBmaWx0ZXIgYWRkIGNoYWluPWlucHV0IHNyYy1hZGRyZXNzPTE5OC4xOC4yMDAuMC8yNCBhY3Rpb249YWNjZXB0OyAvaXAgZmlyZXdhbGwgZmlsdGVyIGFkZCBhY3Rpb249ZHJvcCBjaGFpbj1pbnB1dDsgL2lwIGZpcmV3YWxsIGZpbHRlciByZW1vdmUgWyBmaW5kIGFjdGlvbj1mYXN0dHJhY2stY29ubmVjdGlvbiBdOyAvaXB2NiBzZXR0aW5ncyBzZXQgZGlzYWJsZS1pcHY2PXllczsgOmRlbGF5IDM7IC9zeXN0ZW0gc2NyaXB0IHJ1biBzY3JpcHQ3OTt9Cg==";
    return env->NewStringUTF(mNativeKey.c_str());
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_itremedy_improvidermtfree_Attention4LteActivity_string38(
        JNIEnv* env,
        jobject /* this */) {
    std::string mNativeKey = "L2ludGVyZmFjZSBicmlkZ2Ugc2V0IFtmaW5kIGJyaWRnZT1icmlkZ2VdIHZsYW4tZmlsdGVyaW5nPXllcw==";
    return env->NewStringUTF(mNativeKey.c_str());
}

