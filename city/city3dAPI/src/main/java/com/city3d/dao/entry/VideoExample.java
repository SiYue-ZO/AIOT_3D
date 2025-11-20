package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class VideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCamAddIsNull() {
            addCriterion("cam_add is null");
            return (Criteria) this;
        }

        public Criteria andCamAddIsNotNull() {
            addCriterion("cam_add is not null");
            return (Criteria) this;
        }

        public Criteria andCamAddEqualTo(String value) {
            addCriterion("cam_add =", value, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddNotEqualTo(String value) {
            addCriterion("cam_add <>", value, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddGreaterThan(String value) {
            addCriterion("cam_add >", value, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddGreaterThanOrEqualTo(String value) {
            addCriterion("cam_add >=", value, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddLessThan(String value) {
            addCriterion("cam_add <", value, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddLessThanOrEqualTo(String value) {
            addCriterion("cam_add <=", value, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddLike(String value) {
            addCriterion("cam_add like", value, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddNotLike(String value) {
            addCriterion("cam_add not like", value, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddIn(List<String> values) {
            addCriterion("cam_add in", values, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddNotIn(List<String> values) {
            addCriterion("cam_add not in", values, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddBetween(String value1, String value2) {
            addCriterion("cam_add between", value1, value2, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamAddNotBetween(String value1, String value2) {
            addCriterion("cam_add not between", value1, value2, "camAdd");
            return (Criteria) this;
        }

        public Criteria andCamUrlIsNull() {
            addCriterion("cam_url is null");
            return (Criteria) this;
        }

        public Criteria andCamUrlIsNotNull() {
            addCriterion("cam_url is not null");
            return (Criteria) this;
        }

        public Criteria andCamUrlEqualTo(String value) {
            addCriterion("cam_url =", value, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlNotEqualTo(String value) {
            addCriterion("cam_url <>", value, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlGreaterThan(String value) {
            addCriterion("cam_url >", value, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cam_url >=", value, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlLessThan(String value) {
            addCriterion("cam_url <", value, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlLessThanOrEqualTo(String value) {
            addCriterion("cam_url <=", value, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlLike(String value) {
            addCriterion("cam_url like", value, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlNotLike(String value) {
            addCriterion("cam_url not like", value, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlIn(List<String> values) {
            addCriterion("cam_url in", values, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlNotIn(List<String> values) {
            addCriterion("cam_url not in", values, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlBetween(String value1, String value2) {
            addCriterion("cam_url between", value1, value2, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamUrlNotBetween(String value1, String value2) {
            addCriterion("cam_url not between", value1, value2, "camUrl");
            return (Criteria) this;
        }

        public Criteria andCamTypeIsNull() {
            addCriterion("cam_type is null");
            return (Criteria) this;
        }

        public Criteria andCamTypeIsNotNull() {
            addCriterion("cam_type is not null");
            return (Criteria) this;
        }

        public Criteria andCamTypeEqualTo(String value) {
            addCriterion("cam_type =", value, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeNotEqualTo(String value) {
            addCriterion("cam_type <>", value, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeGreaterThan(String value) {
            addCriterion("cam_type >", value, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cam_type >=", value, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeLessThan(String value) {
            addCriterion("cam_type <", value, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeLessThanOrEqualTo(String value) {
            addCriterion("cam_type <=", value, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeLike(String value) {
            addCriterion("cam_type like", value, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeNotLike(String value) {
            addCriterion("cam_type not like", value, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeIn(List<String> values) {
            addCriterion("cam_type in", values, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeNotIn(List<String> values) {
            addCriterion("cam_type not in", values, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeBetween(String value1, String value2) {
            addCriterion("cam_type between", value1, value2, "camType");
            return (Criteria) this;
        }

        public Criteria andCamTypeNotBetween(String value1, String value2) {
            addCriterion("cam_type not between", value1, value2, "camType");
            return (Criteria) this;
        }

        public Criteria andCamPositionIsNull() {
            addCriterion("cam_position is null");
            return (Criteria) this;
        }

        public Criteria andCamPositionIsNotNull() {
            addCriterion("cam_position is not null");
            return (Criteria) this;
        }

        public Criteria andCamPositionEqualTo(String value) {
            addCriterion("cam_position =", value, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionNotEqualTo(String value) {
            addCriterion("cam_position <>", value, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionGreaterThan(String value) {
            addCriterion("cam_position >", value, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionGreaterThanOrEqualTo(String value) {
            addCriterion("cam_position >=", value, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionLessThan(String value) {
            addCriterion("cam_position <", value, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionLessThanOrEqualTo(String value) {
            addCriterion("cam_position <=", value, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionLike(String value) {
            addCriterion("cam_position like", value, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionNotLike(String value) {
            addCriterion("cam_position not like", value, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionIn(List<String> values) {
            addCriterion("cam_position in", values, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionNotIn(List<String> values) {
            addCriterion("cam_position not in", values, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionBetween(String value1, String value2) {
            addCriterion("cam_position between", value1, value2, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPositionNotBetween(String value1, String value2) {
            addCriterion("cam_position not between", value1, value2, "camPosition");
            return (Criteria) this;
        }

        public Criteria andCamPidIsNull() {
            addCriterion("cam_pid is null");
            return (Criteria) this;
        }

        public Criteria andCamPidIsNotNull() {
            addCriterion("cam_pid is not null");
            return (Criteria) this;
        }

        public Criteria andCamPidEqualTo(String value) {
            addCriterion("cam_pid =", value, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidNotEqualTo(String value) {
            addCriterion("cam_pid <>", value, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidGreaterThan(String value) {
            addCriterion("cam_pid >", value, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidGreaterThanOrEqualTo(String value) {
            addCriterion("cam_pid >=", value, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidLessThan(String value) {
            addCriterion("cam_pid <", value, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidLessThanOrEqualTo(String value) {
            addCriterion("cam_pid <=", value, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidLike(String value) {
            addCriterion("cam_pid like", value, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidNotLike(String value) {
            addCriterion("cam_pid not like", value, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidIn(List<String> values) {
            addCriterion("cam_pid in", values, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidNotIn(List<String> values) {
            addCriterion("cam_pid not in", values, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidBetween(String value1, String value2) {
            addCriterion("cam_pid between", value1, value2, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamPidNotBetween(String value1, String value2) {
            addCriterion("cam_pid not between", value1, value2, "camPid");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeIsNull() {
            addCriterion("cam_isnode is null");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeIsNotNull() {
            addCriterion("cam_isnode is not null");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeEqualTo(Boolean value) {
            addCriterion("cam_isnode =", value, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeNotEqualTo(Boolean value) {
            addCriterion("cam_isnode <>", value, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeGreaterThan(Boolean value) {
            addCriterion("cam_isnode >", value, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("cam_isnode >=", value, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeLessThan(Boolean value) {
            addCriterion("cam_isnode <", value, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeLessThanOrEqualTo(Boolean value) {
            addCriterion("cam_isnode <=", value, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeIn(List<Boolean> values) {
            addCriterion("cam_isnode in", values, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeNotIn(List<Boolean> values) {
            addCriterion("cam_isnode not in", values, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeBetween(Boolean value1, Boolean value2) {
            addCriterion("cam_isnode between", value1, value2, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamIsnodeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("cam_isnode not between", value1, value2, "camIsnode");
            return (Criteria) this;
        }

        public Criteria andCamHolesIsNull() {
            addCriterion("cam_holes is null");
            return (Criteria) this;
        }

        public Criteria andCamHolesIsNotNull() {
            addCriterion("cam_holes is not null");
            return (Criteria) this;
        }

        public Criteria andCamHolesEqualTo(String value) {
            addCriterion("cam_holes =", value, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesNotEqualTo(String value) {
            addCriterion("cam_holes <>", value, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesGreaterThan(String value) {
            addCriterion("cam_holes >", value, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesGreaterThanOrEqualTo(String value) {
            addCriterion("cam_holes >=", value, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesLessThan(String value) {
            addCriterion("cam_holes <", value, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesLessThanOrEqualTo(String value) {
            addCriterion("cam_holes <=", value, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesLike(String value) {
            addCriterion("cam_holes like", value, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesNotLike(String value) {
            addCriterion("cam_holes not like", value, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesIn(List<String> values) {
            addCriterion("cam_holes in", values, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesNotIn(List<String> values) {
            addCriterion("cam_holes not in", values, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesBetween(String value1, String value2) {
            addCriterion("cam_holes between", value1, value2, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamHolesNotBetween(String value1, String value2) {
            addCriterion("cam_holes not between", value1, value2, "camHoles");
            return (Criteria) this;
        }

        public Criteria andCamFovIsNull() {
            addCriterion("cam_fov is null");
            return (Criteria) this;
        }

        public Criteria andCamFovIsNotNull() {
            addCriterion("cam_fov is not null");
            return (Criteria) this;
        }

        public Criteria andCamFovEqualTo(String value) {
            addCriterion("cam_fov =", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovNotEqualTo(String value) {
            addCriterion("cam_fov <>", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovGreaterThan(String value) {
            addCriterion("cam_fov >", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovGreaterThanOrEqualTo(String value) {
            addCriterion("cam_fov >=", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovLessThan(String value) {
            addCriterion("cam_fov <", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovLessThanOrEqualTo(String value) {
            addCriterion("cam_fov <=", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovLike(String value) {
            addCriterion("cam_fov like", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovNotLike(String value) {
            addCriterion("cam_fov not like", value, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovIn(List<String> values) {
            addCriterion("cam_fov in", values, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovNotIn(List<String> values) {
            addCriterion("cam_fov not in", values, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovBetween(String value1, String value2) {
            addCriterion("cam_fov between", value1, value2, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamFovNotBetween(String value1, String value2) {
            addCriterion("cam_fov not between", value1, value2, "camFov");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIsNull() {
            addCriterion("cam_heading is null");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIsNotNull() {
            addCriterion("cam_heading is not null");
            return (Criteria) this;
        }

        public Criteria andCamHeadingEqualTo(String value) {
            addCriterion("cam_heading =", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotEqualTo(String value) {
            addCriterion("cam_heading <>", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingGreaterThan(String value) {
            addCriterion("cam_heading >", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingGreaterThanOrEqualTo(String value) {
            addCriterion("cam_heading >=", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLessThan(String value) {
            addCriterion("cam_heading <", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLessThanOrEqualTo(String value) {
            addCriterion("cam_heading <=", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingLike(String value) {
            addCriterion("cam_heading like", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotLike(String value) {
            addCriterion("cam_heading not like", value, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingIn(List<String> values) {
            addCriterion("cam_heading in", values, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotIn(List<String> values) {
            addCriterion("cam_heading not in", values, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingBetween(String value1, String value2) {
            addCriterion("cam_heading between", value1, value2, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamHeadingNotBetween(String value1, String value2) {
            addCriterion("cam_heading not between", value1, value2, "camHeading");
            return (Criteria) this;
        }

        public Criteria andCamPitchIsNull() {
            addCriterion("cam_pitch is null");
            return (Criteria) this;
        }

        public Criteria andCamPitchIsNotNull() {
            addCriterion("cam_pitch is not null");
            return (Criteria) this;
        }

        public Criteria andCamPitchEqualTo(String value) {
            addCriterion("cam_pitch =", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotEqualTo(String value) {
            addCriterion("cam_pitch <>", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchGreaterThan(String value) {
            addCriterion("cam_pitch >", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchGreaterThanOrEqualTo(String value) {
            addCriterion("cam_pitch >=", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLessThan(String value) {
            addCriterion("cam_pitch <", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLessThanOrEqualTo(String value) {
            addCriterion("cam_pitch <=", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchLike(String value) {
            addCriterion("cam_pitch like", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotLike(String value) {
            addCriterion("cam_pitch not like", value, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchIn(List<String> values) {
            addCriterion("cam_pitch in", values, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotIn(List<String> values) {
            addCriterion("cam_pitch not in", values, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchBetween(String value1, String value2) {
            addCriterion("cam_pitch between", value1, value2, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamPitchNotBetween(String value1, String value2) {
            addCriterion("cam_pitch not between", value1, value2, "camPitch");
            return (Criteria) this;
        }

        public Criteria andCamRollIsNull() {
            addCriterion("cam_roll is null");
            return (Criteria) this;
        }

        public Criteria andCamRollIsNotNull() {
            addCriterion("cam_roll is not null");
            return (Criteria) this;
        }

        public Criteria andCamRollEqualTo(String value) {
            addCriterion("cam_roll =", value, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollNotEqualTo(String value) {
            addCriterion("cam_roll <>", value, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollGreaterThan(String value) {
            addCriterion("cam_roll >", value, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollGreaterThanOrEqualTo(String value) {
            addCriterion("cam_roll >=", value, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollLessThan(String value) {
            addCriterion("cam_roll <", value, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollLessThanOrEqualTo(String value) {
            addCriterion("cam_roll <=", value, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollLike(String value) {
            addCriterion("cam_roll like", value, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollNotLike(String value) {
            addCriterion("cam_roll not like", value, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollIn(List<String> values) {
            addCriterion("cam_roll in", values, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollNotIn(List<String> values) {
            addCriterion("cam_roll not in", values, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollBetween(String value1, String value2) {
            addCriterion("cam_roll between", value1, value2, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamRollNotBetween(String value1, String value2) {
            addCriterion("cam_roll not between", value1, value2, "camRoll");
            return (Criteria) this;
        }

        public Criteria andCamNearIsNull() {
            addCriterion("cam_near is null");
            return (Criteria) this;
        }

        public Criteria andCamNearIsNotNull() {
            addCriterion("cam_near is not null");
            return (Criteria) this;
        }

        public Criteria andCamNearEqualTo(String value) {
            addCriterion("cam_near =", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearNotEqualTo(String value) {
            addCriterion("cam_near <>", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearGreaterThan(String value) {
            addCriterion("cam_near >", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearGreaterThanOrEqualTo(String value) {
            addCriterion("cam_near >=", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearLessThan(String value) {
            addCriterion("cam_near <", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearLessThanOrEqualTo(String value) {
            addCriterion("cam_near <=", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearLike(String value) {
            addCriterion("cam_near like", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearNotLike(String value) {
            addCriterion("cam_near not like", value, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearIn(List<String> values) {
            addCriterion("cam_near in", values, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearNotIn(List<String> values) {
            addCriterion("cam_near not in", values, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearBetween(String value1, String value2) {
            addCriterion("cam_near between", value1, value2, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamNearNotBetween(String value1, String value2) {
            addCriterion("cam_near not between", value1, value2, "camNear");
            return (Criteria) this;
        }

        public Criteria andCamFarIsNull() {
            addCriterion("cam_far is null");
            return (Criteria) this;
        }

        public Criteria andCamFarIsNotNull() {
            addCriterion("cam_far is not null");
            return (Criteria) this;
        }

        public Criteria andCamFarEqualTo(String value) {
            addCriterion("cam_far =", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarNotEqualTo(String value) {
            addCriterion("cam_far <>", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarGreaterThan(String value) {
            addCriterion("cam_far >", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarGreaterThanOrEqualTo(String value) {
            addCriterion("cam_far >=", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarLessThan(String value) {
            addCriterion("cam_far <", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarLessThanOrEqualTo(String value) {
            addCriterion("cam_far <=", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarLike(String value) {
            addCriterion("cam_far like", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarNotLike(String value) {
            addCriterion("cam_far not like", value, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarIn(List<String> values) {
            addCriterion("cam_far in", values, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarNotIn(List<String> values) {
            addCriterion("cam_far not in", values, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarBetween(String value1, String value2) {
            addCriterion("cam_far between", value1, value2, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamFarNotBetween(String value1, String value2) {
            addCriterion("cam_far not between", value1, value2, "camFar");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioIsNull() {
            addCriterion("cam_aspectratio is null");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioIsNotNull() {
            addCriterion("cam_aspectratio is not null");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioEqualTo(String value) {
            addCriterion("cam_aspectratio =", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioNotEqualTo(String value) {
            addCriterion("cam_aspectratio <>", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioGreaterThan(String value) {
            addCriterion("cam_aspectratio >", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioGreaterThanOrEqualTo(String value) {
            addCriterion("cam_aspectratio >=", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioLessThan(String value) {
            addCriterion("cam_aspectratio <", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioLessThanOrEqualTo(String value) {
            addCriterion("cam_aspectratio <=", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioLike(String value) {
            addCriterion("cam_aspectratio like", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioNotLike(String value) {
            addCriterion("cam_aspectratio not like", value, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioIn(List<String> values) {
            addCriterion("cam_aspectratio in", values, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioNotIn(List<String> values) {
            addCriterion("cam_aspectratio not in", values, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioBetween(String value1, String value2) {
            addCriterion("cam_aspectratio between", value1, value2, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamAspectratioNotBetween(String value1, String value2) {
            addCriterion("cam_aspectratio not between", value1, value2, "camAspectratio");
            return (Criteria) this;
        }

        public Criteria andCamRtspIsNull() {
            addCriterion("cam_rtsp is null");
            return (Criteria) this;
        }

        public Criteria andCamRtspIsNotNull() {
            addCriterion("cam_rtsp is not null");
            return (Criteria) this;
        }

        public Criteria andCamRtspEqualTo(String value) {
            addCriterion("cam_rtsp =", value, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspNotEqualTo(String value) {
            addCriterion("cam_rtsp <>", value, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspGreaterThan(String value) {
            addCriterion("cam_rtsp >", value, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspGreaterThanOrEqualTo(String value) {
            addCriterion("cam_rtsp >=", value, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspLessThan(String value) {
            addCriterion("cam_rtsp <", value, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspLessThanOrEqualTo(String value) {
            addCriterion("cam_rtsp <=", value, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspLike(String value) {
            addCriterion("cam_rtsp like", value, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspNotLike(String value) {
            addCriterion("cam_rtsp not like", value, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspIn(List<String> values) {
            addCriterion("cam_rtsp in", values, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspNotIn(List<String> values) {
            addCriterion("cam_rtsp not in", values, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspBetween(String value1, String value2) {
            addCriterion("cam_rtsp between", value1, value2, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamRtspNotBetween(String value1, String value2) {
            addCriterion("cam_rtsp not between", value1, value2, "camRtsp");
            return (Criteria) this;
        }

        public Criteria andCamPortIsNull() {
            addCriterion("cam_port is null");
            return (Criteria) this;
        }

        public Criteria andCamPortIsNotNull() {
            addCriterion("cam_port is not null");
            return (Criteria) this;
        }

        public Criteria andCamPortEqualTo(String value) {
            addCriterion("cam_port =", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortNotEqualTo(String value) {
            addCriterion("cam_port <>", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortGreaterThan(String value) {
            addCriterion("cam_port >", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortGreaterThanOrEqualTo(String value) {
            addCriterion("cam_port >=", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortLessThan(String value) {
            addCriterion("cam_port <", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortLessThanOrEqualTo(String value) {
            addCriterion("cam_port <=", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortLike(String value) {
            addCriterion("cam_port like", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortNotLike(String value) {
            addCriterion("cam_port not like", value, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortIn(List<String> values) {
            addCriterion("cam_port in", values, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortNotIn(List<String> values) {
            addCriterion("cam_port not in", values, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortBetween(String value1, String value2) {
            addCriterion("cam_port between", value1, value2, "camPort");
            return (Criteria) this;
        }

        public Criteria andCamPortNotBetween(String value1, String value2) {
            addCriterion("cam_port not between", value1, value2, "camPort");
            return (Criteria) this;
        }

        public Criteria andMacUrlIsNull() {
            addCriterion("mac_url is null");
            return (Criteria) this;
        }

        public Criteria andMacUrlIsNotNull() {
            addCriterion("mac_url is not null");
            return (Criteria) this;
        }

        public Criteria andMacUrlEqualTo(String value) {
            addCriterion("mac_url =", value, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlNotEqualTo(String value) {
            addCriterion("mac_url <>", value, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlGreaterThan(String value) {
            addCriterion("mac_url >", value, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlGreaterThanOrEqualTo(String value) {
            addCriterion("mac_url >=", value, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlLessThan(String value) {
            addCriterion("mac_url <", value, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlLessThanOrEqualTo(String value) {
            addCriterion("mac_url <=", value, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlLike(String value) {
            addCriterion("mac_url like", value, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlNotLike(String value) {
            addCriterion("mac_url not like", value, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlIn(List<String> values) {
            addCriterion("mac_url in", values, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlNotIn(List<String> values) {
            addCriterion("mac_url not in", values, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlBetween(String value1, String value2) {
            addCriterion("mac_url between", value1, value2, "macUrl");
            return (Criteria) this;
        }

        public Criteria andMacUrlNotBetween(String value1, String value2) {
            addCriterion("mac_url not between", value1, value2, "macUrl");
            return (Criteria) this;
        }

        public Criteria andIsIndoorIsNull() {
            addCriterion("is_indoor is null");
            return (Criteria) this;
        }

        public Criteria andIsIndoorIsNotNull() {
            addCriterion("is_indoor is not null");
            return (Criteria) this;
        }

        public Criteria andIsIndoorEqualTo(String value) {
            addCriterion("is_indoor =", value, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorNotEqualTo(String value) {
            addCriterion("is_indoor <>", value, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorGreaterThan(String value) {
            addCriterion("is_indoor >", value, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorGreaterThanOrEqualTo(String value) {
            addCriterion("is_indoor >=", value, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorLessThan(String value) {
            addCriterion("is_indoor <", value, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorLessThanOrEqualTo(String value) {
            addCriterion("is_indoor <=", value, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorLike(String value) {
            addCriterion("is_indoor like", value, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorNotLike(String value) {
            addCriterion("is_indoor not like", value, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorIn(List<String> values) {
            addCriterion("is_indoor in", values, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorNotIn(List<String> values) {
            addCriterion("is_indoor not in", values, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorBetween(String value1, String value2) {
            addCriterion("is_indoor between", value1, value2, "isIndoor");
            return (Criteria) this;
        }

        public Criteria andIsIndoorNotBetween(String value1, String value2) {
            addCriterion("is_indoor not between", value1, value2, "isIndoor");
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