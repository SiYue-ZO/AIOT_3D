package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class FaceIdentityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FaceIdentityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFaceIdIsNull() {
            addCriterion("face_id is null");
            return (Criteria) this;
        }

        public Criteria andFaceIdIsNotNull() {
            addCriterion("face_id is not null");
            return (Criteria) this;
        }

        public Criteria andFaceIdEqualTo(String value) {
            addCriterion("face_id =", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotEqualTo(String value) {
            addCriterion("face_id <>", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdGreaterThan(String value) {
            addCriterion("face_id >", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("face_id >=", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdLessThan(String value) {
            addCriterion("face_id <", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdLessThanOrEqualTo(String value) {
            addCriterion("face_id <=", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdLike(String value) {
            addCriterion("face_id like", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotLike(String value) {
            addCriterion("face_id not like", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdIn(List<String> values) {
            addCriterion("face_id in", values, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotIn(List<String> values) {
            addCriterion("face_id not in", values, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdBetween(String value1, String value2) {
            addCriterion("face_id between", value1, value2, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotBetween(String value1, String value2) {
            addCriterion("face_id not between", value1, value2, "faceId");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraIdIsNull() {
            addCriterion("camera_id is null");
            return (Criteria) this;
        }

        public Criteria andCameraIdIsNotNull() {
            addCriterion("camera_id is not null");
            return (Criteria) this;
        }

        public Criteria andCameraIdEqualTo(String value) {
            addCriterion("camera_id =", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotEqualTo(String value) {
            addCriterion("camera_id <>", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdGreaterThan(String value) {
            addCriterion("camera_id >", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdGreaterThanOrEqualTo(String value) {
            addCriterion("camera_id >=", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLessThan(String value) {
            addCriterion("camera_id <", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLessThanOrEqualTo(String value) {
            addCriterion("camera_id <=", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLike(String value) {
            addCriterion("camera_id like", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotLike(String value) {
            addCriterion("camera_id not like", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdIn(List<String> values) {
            addCriterion("camera_id in", values, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotIn(List<String> values) {
            addCriterion("camera_id not in", values, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdBetween(String value1, String value2) {
            addCriterion("camera_id between", value1, value2, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotBetween(String value1, String value2) {
            addCriterion("camera_id not between", value1, value2, "cameraId");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgIdEqualTo(String value) {
            addCriterion("img_id =", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotEqualTo(String value) {
            addCriterion("img_id <>", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThan(String value) {
            addCriterion("img_id >", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThanOrEqualTo(String value) {
            addCriterion("img_id >=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThan(String value) {
            addCriterion("img_id <", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThanOrEqualTo(String value) {
            addCriterion("img_id <=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLike(String value) {
            addCriterion("img_id like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotLike(String value) {
            addCriterion("img_id not like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdIn(List<String> values) {
            addCriterion("img_id in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotIn(List<String> values) {
            addCriterion("img_id not in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdBetween(String value1, String value2) {
            addCriterion("img_id between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotBetween(String value1, String value2) {
            addCriterion("img_id not between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(String value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(String value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(String value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(String value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(String value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLike(String value) {
            addCriterion("card_id like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotLike(String value) {
            addCriterion("card_id not like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<String> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<String> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(String value1, String value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(String value1, String value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRepoTypeIsNull() {
            addCriterion("repo_type is null");
            return (Criteria) this;
        }

        public Criteria andRepoTypeIsNotNull() {
            addCriterion("repo_type is not null");
            return (Criteria) this;
        }

        public Criteria andRepoTypeEqualTo(String value) {
            addCriterion("repo_type =", value, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeNotEqualTo(String value) {
            addCriterion("repo_type <>", value, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeGreaterThan(String value) {
            addCriterion("repo_type >", value, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("repo_type >=", value, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeLessThan(String value) {
            addCriterion("repo_type <", value, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeLessThanOrEqualTo(String value) {
            addCriterion("repo_type <=", value, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeLike(String value) {
            addCriterion("repo_type like", value, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeNotLike(String value) {
            addCriterion("repo_type not like", value, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeIn(List<String> values) {
            addCriterion("repo_type in", values, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeNotIn(List<String> values) {
            addCriterion("repo_type not in", values, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeBetween(String value1, String value2) {
            addCriterion("repo_type between", value1, value2, "repoType");
            return (Criteria) this;
        }

        public Criteria andRepoTypeNotBetween(String value1, String value2) {
            addCriterion("repo_type not between", value1, value2, "repoType");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeIsNull() {
            addCriterion("capture_time is null");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeIsNotNull() {
            addCriterion("capture_time is not null");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeEqualTo(String value) {
            addCriterion("capture_time =", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeNotEqualTo(String value) {
            addCriterion("capture_time <>", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeGreaterThan(String value) {
            addCriterion("capture_time >", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeGreaterThanOrEqualTo(String value) {
            addCriterion("capture_time >=", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeLessThan(String value) {
            addCriterion("capture_time <", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeLessThanOrEqualTo(String value) {
            addCriterion("capture_time <=", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeLike(String value) {
            addCriterion("capture_time like", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeNotLike(String value) {
            addCriterion("capture_time not like", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeIn(List<String> values) {
            addCriterion("capture_time in", values, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeNotIn(List<String> values) {
            addCriterion("capture_time not in", values, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeBetween(String value1, String value2) {
            addCriterion("capture_time between", value1, value2, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeNotBetween(String value1, String value2) {
            addCriterion("capture_time not between", value1, value2, "captureTime");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIdCardNameIsNull() {
            addCriterion("id_card_name is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNameIsNotNull() {
            addCriterion("id_card_name is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNameEqualTo(String value) {
            addCriterion("id_card_name =", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotEqualTo(String value) {
            addCriterion("id_card_name <>", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameGreaterThan(String value) {
            addCriterion("id_card_name >", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_name >=", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameLessThan(String value) {
            addCriterion("id_card_name <", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameLessThanOrEqualTo(String value) {
            addCriterion("id_card_name <=", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameLike(String value) {
            addCriterion("id_card_name like", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotLike(String value) {
            addCriterion("id_card_name not like", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameIn(List<String> values) {
            addCriterion("id_card_name in", values, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotIn(List<String> values) {
            addCriterion("id_card_name not in", values, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameBetween(String value1, String value2) {
            addCriterion("id_card_name between", value1, value2, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotBetween(String value1, String value2) {
            addCriterion("id_card_name not between", value1, value2, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderIsNull() {
            addCriterion("id_card_gender is null");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderIsNotNull() {
            addCriterion("id_card_gender is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderEqualTo(String value) {
            addCriterion("id_card_gender =", value, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderNotEqualTo(String value) {
            addCriterion("id_card_gender <>", value, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderGreaterThan(String value) {
            addCriterion("id_card_gender >", value, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_gender >=", value, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderLessThan(String value) {
            addCriterion("id_card_gender <", value, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderLessThanOrEqualTo(String value) {
            addCriterion("id_card_gender <=", value, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderLike(String value) {
            addCriterion("id_card_gender like", value, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderNotLike(String value) {
            addCriterion("id_card_gender not like", value, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderIn(List<String> values) {
            addCriterion("id_card_gender in", values, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderNotIn(List<String> values) {
            addCriterion("id_card_gender not in", values, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderBetween(String value1, String value2) {
            addCriterion("id_card_gender between", value1, value2, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardGenderNotBetween(String value1, String value2) {
            addCriterion("id_card_gender not between", value1, value2, "idCardGender");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalIsNull() {
            addCriterion("id_card_national is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalIsNotNull() {
            addCriterion("id_card_national is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalEqualTo(String value) {
            addCriterion("id_card_national =", value, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalNotEqualTo(String value) {
            addCriterion("id_card_national <>", value, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalGreaterThan(String value) {
            addCriterion("id_card_national >", value, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_national >=", value, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalLessThan(String value) {
            addCriterion("id_card_national <", value, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalLessThanOrEqualTo(String value) {
            addCriterion("id_card_national <=", value, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalLike(String value) {
            addCriterion("id_card_national like", value, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalNotLike(String value) {
            addCriterion("id_card_national not like", value, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalIn(List<String> values) {
            addCriterion("id_card_national in", values, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalNotIn(List<String> values) {
            addCriterion("id_card_national not in", values, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalBetween(String value1, String value2) {
            addCriterion("id_card_national between", value1, value2, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardNationalNotBetween(String value1, String value2) {
            addCriterion("id_card_national not between", value1, value2, "idCardNational");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayIsNull() {
            addCriterion("id_card_birthday is null");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayIsNotNull() {
            addCriterion("id_card_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayEqualTo(String value) {
            addCriterion("id_card_birthday =", value, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayNotEqualTo(String value) {
            addCriterion("id_card_birthday <>", value, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayGreaterThan(String value) {
            addCriterion("id_card_birthday >", value, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_birthday >=", value, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayLessThan(String value) {
            addCriterion("id_card_birthday <", value, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayLessThanOrEqualTo(String value) {
            addCriterion("id_card_birthday <=", value, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayLike(String value) {
            addCriterion("id_card_birthday like", value, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayNotLike(String value) {
            addCriterion("id_card_birthday not like", value, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayIn(List<String> values) {
            addCriterion("id_card_birthday in", values, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayNotIn(List<String> values) {
            addCriterion("id_card_birthday not in", values, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayBetween(String value1, String value2) {
            addCriterion("id_card_birthday between", value1, value2, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardBirthdayNotBetween(String value1, String value2) {
            addCriterion("id_card_birthday not between", value1, value2, "idCardBirthday");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressIsNull() {
            addCriterion("id_card_address is null");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressIsNotNull() {
            addCriterion("id_card_address is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressEqualTo(String value) {
            addCriterion("id_card_address =", value, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressNotEqualTo(String value) {
            addCriterion("id_card_address <>", value, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressGreaterThan(String value) {
            addCriterion("id_card_address >", value, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_address >=", value, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressLessThan(String value) {
            addCriterion("id_card_address <", value, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressLessThanOrEqualTo(String value) {
            addCriterion("id_card_address <=", value, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressLike(String value) {
            addCriterion("id_card_address like", value, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressNotLike(String value) {
            addCriterion("id_card_address not like", value, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressIn(List<String> values) {
            addCriterion("id_card_address in", values, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressNotIn(List<String> values) {
            addCriterion("id_card_address not in", values, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressBetween(String value1, String value2) {
            addCriterion("id_card_address between", value1, value2, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardAddressNotBetween(String value1, String value2) {
            addCriterion("id_card_address not between", value1, value2, "idCardAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardIdIsNull() {
            addCriterion("id_card_id is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIdIsNotNull() {
            addCriterion("id_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardIdEqualTo(String value) {
            addCriterion("id_card_id =", value, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdNotEqualTo(String value) {
            addCriterion("id_card_id <>", value, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdGreaterThan(String value) {
            addCriterion("id_card_id >", value, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_id >=", value, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdLessThan(String value) {
            addCriterion("id_card_id <", value, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdLessThanOrEqualTo(String value) {
            addCriterion("id_card_id <=", value, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdLike(String value) {
            addCriterion("id_card_id like", value, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdNotLike(String value) {
            addCriterion("id_card_id not like", value, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdIn(List<String> values) {
            addCriterion("id_card_id in", values, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdNotIn(List<String> values) {
            addCriterion("id_card_id not in", values, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdBetween(String value1, String value2) {
            addCriterion("id_card_id between", value1, value2, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardIdNotBetween(String value1, String value2) {
            addCriterion("id_card_id not between", value1, value2, "idCardId");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerIsNull() {
            addCriterion("id_card_maker is null");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerIsNotNull() {
            addCriterion("id_card_maker is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerEqualTo(String value) {
            addCriterion("id_card_maker =", value, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerNotEqualTo(String value) {
            addCriterion("id_card_maker <>", value, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerGreaterThan(String value) {
            addCriterion("id_card_maker >", value, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_maker >=", value, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerLessThan(String value) {
            addCriterion("id_card_maker <", value, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerLessThanOrEqualTo(String value) {
            addCriterion("id_card_maker <=", value, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerLike(String value) {
            addCriterion("id_card_maker like", value, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerNotLike(String value) {
            addCriterion("id_card_maker not like", value, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerIn(List<String> values) {
            addCriterion("id_card_maker in", values, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerNotIn(List<String> values) {
            addCriterion("id_card_maker not in", values, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerBetween(String value1, String value2) {
            addCriterion("id_card_maker between", value1, value2, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardMakerNotBetween(String value1, String value2) {
            addCriterion("id_card_maker not between", value1, value2, "idCardMaker");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateIsNull() {
            addCriterion("id_card_start_date is null");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateIsNotNull() {
            addCriterion("id_card_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateEqualTo(String value) {
            addCriterion("id_card_start_date =", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateNotEqualTo(String value) {
            addCriterion("id_card_start_date <>", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateGreaterThan(String value) {
            addCriterion("id_card_start_date >", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_start_date >=", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateLessThan(String value) {
            addCriterion("id_card_start_date <", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateLessThanOrEqualTo(String value) {
            addCriterion("id_card_start_date <=", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateLike(String value) {
            addCriterion("id_card_start_date like", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateNotLike(String value) {
            addCriterion("id_card_start_date not like", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateIn(List<String> values) {
            addCriterion("id_card_start_date in", values, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateNotIn(List<String> values) {
            addCriterion("id_card_start_date not in", values, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateBetween(String value1, String value2) {
            addCriterion("id_card_start_date between", value1, value2, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateNotBetween(String value1, String value2) {
            addCriterion("id_card_start_date not between", value1, value2, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateIsNull() {
            addCriterion("id_card_end_date is null");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateIsNotNull() {
            addCriterion("id_card_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateEqualTo(String value) {
            addCriterion("id_card_end_date =", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateNotEqualTo(String value) {
            addCriterion("id_card_end_date <>", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateGreaterThan(String value) {
            addCriterion("id_card_end_date >", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_end_date >=", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateLessThan(String value) {
            addCriterion("id_card_end_date <", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateLessThanOrEqualTo(String value) {
            addCriterion("id_card_end_date <=", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateLike(String value) {
            addCriterion("id_card_end_date like", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateNotLike(String value) {
            addCriterion("id_card_end_date not like", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateIn(List<String> values) {
            addCriterion("id_card_end_date in", values, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateNotIn(List<String> values) {
            addCriterion("id_card_end_date not in", values, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateBetween(String value1, String value2) {
            addCriterion("id_card_end_date between", value1, value2, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateNotBetween(String value1, String value2) {
            addCriterion("id_card_end_date not between", value1, value2, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardImgIsNull() {
            addCriterion("id_card_img is null");
            return (Criteria) this;
        }

        public Criteria andIdCardImgIsNotNull() {
            addCriterion("id_card_img is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardImgEqualTo(String value) {
            addCriterion("id_card_img =", value, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgNotEqualTo(String value) {
            addCriterion("id_card_img <>", value, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgGreaterThan(String value) {
            addCriterion("id_card_img >", value, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_img >=", value, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgLessThan(String value) {
            addCriterion("id_card_img <", value, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgLessThanOrEqualTo(String value) {
            addCriterion("id_card_img <=", value, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgLike(String value) {
            addCriterion("id_card_img like", value, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgNotLike(String value) {
            addCriterion("id_card_img not like", value, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgIn(List<String> values) {
            addCriterion("id_card_img in", values, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgNotIn(List<String> values) {
            addCriterion("id_card_img not in", values, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgBetween(String value1, String value2) {
            addCriterion("id_card_img between", value1, value2, "idCardImg");
            return (Criteria) this;
        }

        public Criteria andIdCardImgNotBetween(String value1, String value2) {
            addCriterion("id_card_img not between", value1, value2, "idCardImg");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}