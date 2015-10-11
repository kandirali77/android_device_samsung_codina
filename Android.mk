ifeq ($(TARGET_DEVICE),codina)
    LOCAL_PATH := $(call my-dir)
    include $(call first-makefiles-under,$(LOCAL_PATH))
    include $LOCAL_PATH/AndroidProducts.mk
endif
