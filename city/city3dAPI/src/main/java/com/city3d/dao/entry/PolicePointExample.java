package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PolicePointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PolicePointExample() {
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(String value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(String value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(String value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(String value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(String value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(String value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLike(String value) {
            addCriterion("p_id like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotLike(String value) {
            addCriterion("p_id not like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<String> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<String> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(String value1, String value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(String value1, String value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPTypeIsNull() {
            addCriterion("p_type is null");
            return (Criteria) this;
        }

        public Criteria andPTypeIsNotNull() {
            addCriterion("p_type is not null");
            return (Criteria) this;
        }

        public Criteria andPTypeEqualTo(String value) {
            addCriterion("p_type =", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotEqualTo(String value) {
            addCriterion("p_type <>", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeGreaterThan(String value) {
            addCriterion("p_type >", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeGreaterThanOrEqualTo(String value) {
            addCriterion("p_type >=", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeLessThan(String value) {
            addCriterion("p_type <", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeLessThanOrEqualTo(String value) {
            addCriterion("p_type <=", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeLike(String value) {
            addCriterion("p_type like", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotLike(String value) {
            addCriterion("p_type not like", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeIn(List<String> values) {
            addCriterion("p_type in", values, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotIn(List<String> values) {
            addCriterion("p_type not in", values, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeBetween(String value1, String value2) {
            addCriterion("p_type between", value1, value2, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotBetween(String value1, String value2) {
            addCriterion("p_type not between", value1, value2, "pType");
            return (Criteria) this;
        }

        public Criteria andPPoiIsNull() {
            addCriterion("p_poi is null");
            return (Criteria) this;
        }

        public Criteria andPPoiIsNotNull() {
            addCriterion("p_poi is not null");
            return (Criteria) this;
        }

        public Criteria andPPoiEqualTo(String value) {
            addCriterion("p_poi =", value, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiNotEqualTo(String value) {
            addCriterion("p_poi <>", value, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiGreaterThan(String value) {
            addCriterion("p_poi >", value, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiGreaterThanOrEqualTo(String value) {
            addCriterion("p_poi >=", value, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiLessThan(String value) {
            addCriterion("p_poi <", value, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiLessThanOrEqualTo(String value) {
            addCriterion("p_poi <=", value, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiLike(String value) {
            addCriterion("p_poi like", value, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiNotLike(String value) {
            addCriterion("p_poi not like", value, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiIn(List<String> values) {
            addCriterion("p_poi in", values, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiNotIn(List<String> values) {
            addCriterion("p_poi not in", values, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiBetween(String value1, String value2) {
            addCriterion("p_poi between", value1, value2, "pPoi");
            return (Criteria) this;
        }

        public Criteria andPPoiNotBetween(String value1, String value2) {
            addCriterion("p_poi not between", value1, value2, "pPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiIsNull() {
            addCriterion("cam_poi is null");
            return (Criteria) this;
        }

        public Criteria andCamPoiIsNotNull() {
            addCriterion("cam_poi is not null");
            return (Criteria) this;
        }

        public Criteria andCamPoiEqualTo(String value) {
            addCriterion("cam_poi =", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotEqualTo(String value) {
            addCriterion("cam_poi <>", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiGreaterThan(String value) {
            addCriterion("cam_poi >", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiGreaterThanOrEqualTo(String value) {
            addCriterion("cam_poi >=", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLessThan(String value) {
            addCriterion("cam_poi <", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLessThanOrEqualTo(String value) {
            addCriterion("cam_poi <=", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiLike(String value) {
            addCriterion("cam_poi like", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotLike(String value) {
            addCriterion("cam_poi not like", value, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiIn(List<String> values) {
            addCriterion("cam_poi in", values, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotIn(List<String> values) {
            addCriterion("cam_poi not in", values, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiBetween(String value1, String value2) {
            addCriterion("cam_poi between", value1, value2, "camPoi");
            return (Criteria) this;
        }

        public Criteria andCamPoiNotBetween(String value1, String value2) {
            addCriterion("cam_poi not between", value1, value2, "camPoi");
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

        public Criteria andPColorIsNull() {
            addCriterion("p_color is null");
            return (Criteria) this;
        }

        public Criteria andPColorIsNotNull() {
            addCriterion("p_color is not null");
            return (Criteria) this;
        }

        public Criteria andPColorEqualTo(String value) {
            addCriterion("p_color =", value, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorNotEqualTo(String value) {
            addCriterion("p_color <>", value, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorGreaterThan(String value) {
            addCriterion("p_color >", value, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorGreaterThanOrEqualTo(String value) {
            addCriterion("p_color >=", value, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorLessThan(String value) {
            addCriterion("p_color <", value, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorLessThanOrEqualTo(String value) {
            addCriterion("p_color <=", value, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorLike(String value) {
            addCriterion("p_color like", value, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorNotLike(String value) {
            addCriterion("p_color not like", value, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorIn(List<String> values) {
            addCriterion("p_color in", values, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorNotIn(List<String> values) {
            addCriterion("p_color not in", values, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorBetween(String value1, String value2) {
            addCriterion("p_color between", value1, value2, "pColor");
            return (Criteria) this;
        }

        public Criteria andPColorNotBetween(String value1, String value2) {
            addCriterion("p_color not between", value1, value2, "pColor");
            return (Criteria) this;
        }

        public Criteria andNameCheckedIsNull() {
            addCriterion("name_checked is null");
            return (Criteria) this;
        }

        public Criteria andNameCheckedIsNotNull() {
            addCriterion("name_checked is not null");
            return (Criteria) this;
        }

        public Criteria andNameCheckedEqualTo(String value) {
            addCriterion("name_checked =", value, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedNotEqualTo(String value) {
            addCriterion("name_checked <>", value, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedGreaterThan(String value) {
            addCriterion("name_checked >", value, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedGreaterThanOrEqualTo(String value) {
            addCriterion("name_checked >=", value, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedLessThan(String value) {
            addCriterion("name_checked <", value, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedLessThanOrEqualTo(String value) {
            addCriterion("name_checked <=", value, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedLike(String value) {
            addCriterion("name_checked like", value, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedNotLike(String value) {
            addCriterion("name_checked not like", value, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedIn(List<String> values) {
            addCriterion("name_checked in", values, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedNotIn(List<String> values) {
            addCriterion("name_checked not in", values, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedBetween(String value1, String value2) {
            addCriterion("name_checked between", value1, value2, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCheckedNotBetween(String value1, String value2) {
            addCriterion("name_checked not between", value1, value2, "nameChecked");
            return (Criteria) this;
        }

        public Criteria andNameCloseIsNull() {
            addCriterion("name_close is null");
            return (Criteria) this;
        }

        public Criteria andNameCloseIsNotNull() {
            addCriterion("name_close is not null");
            return (Criteria) this;
        }

        public Criteria andNameCloseEqualTo(String value) {
            addCriterion("name_close =", value, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseNotEqualTo(String value) {
            addCriterion("name_close <>", value, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseGreaterThan(String value) {
            addCriterion("name_close >", value, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseGreaterThanOrEqualTo(String value) {
            addCriterion("name_close >=", value, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseLessThan(String value) {
            addCriterion("name_close <", value, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseLessThanOrEqualTo(String value) {
            addCriterion("name_close <=", value, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseLike(String value) {
            addCriterion("name_close like", value, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseNotLike(String value) {
            addCriterion("name_close not like", value, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseIn(List<String> values) {
            addCriterion("name_close in", values, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseNotIn(List<String> values) {
            addCriterion("name_close not in", values, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseBetween(String value1, String value2) {
            addCriterion("name_close between", value1, value2, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameCloseNotBetween(String value1, String value2) {
            addCriterion("name_close not between", value1, value2, "nameClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseIsNull() {
            addCriterion("name_sub_close is null");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseIsNotNull() {
            addCriterion("name_sub_close is not null");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseEqualTo(String value) {
            addCriterion("name_sub_close =", value, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseNotEqualTo(String value) {
            addCriterion("name_sub_close <>", value, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseGreaterThan(String value) {
            addCriterion("name_sub_close >", value, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseGreaterThanOrEqualTo(String value) {
            addCriterion("name_sub_close >=", value, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseLessThan(String value) {
            addCriterion("name_sub_close <", value, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseLessThanOrEqualTo(String value) {
            addCriterion("name_sub_close <=", value, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseLike(String value) {
            addCriterion("name_sub_close like", value, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseNotLike(String value) {
            addCriterion("name_sub_close not like", value, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseIn(List<String> values) {
            addCriterion("name_sub_close in", values, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseNotIn(List<String> values) {
            addCriterion("name_sub_close not in", values, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseBetween(String value1, String value2) {
            addCriterion("name_sub_close between", value1, value2, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andNameSubCloseNotBetween(String value1, String value2) {
            addCriterion("name_sub_close not between", value1, value2, "nameSubClose");
            return (Criteria) this;
        }

        public Criteria andIdCheckedIsNull() {
            addCriterion("id_checked is null");
            return (Criteria) this;
        }

        public Criteria andIdCheckedIsNotNull() {
            addCriterion("id_checked is not null");
            return (Criteria) this;
        }

        public Criteria andIdCheckedEqualTo(String value) {
            addCriterion("id_checked =", value, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedNotEqualTo(String value) {
            addCriterion("id_checked <>", value, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedGreaterThan(String value) {
            addCriterion("id_checked >", value, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedGreaterThanOrEqualTo(String value) {
            addCriterion("id_checked >=", value, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedLessThan(String value) {
            addCriterion("id_checked <", value, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedLessThanOrEqualTo(String value) {
            addCriterion("id_checked <=", value, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedLike(String value) {
            addCriterion("id_checked like", value, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedNotLike(String value) {
            addCriterion("id_checked not like", value, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedIn(List<String> values) {
            addCriterion("id_checked in", values, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedNotIn(List<String> values) {
            addCriterion("id_checked not in", values, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedBetween(String value1, String value2) {
            addCriterion("id_checked between", value1, value2, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCheckedNotBetween(String value1, String value2) {
            addCriterion("id_checked not between", value1, value2, "idChecked");
            return (Criteria) this;
        }

        public Criteria andIdCloseIsNull() {
            addCriterion("id_close is null");
            return (Criteria) this;
        }

        public Criteria andIdCloseIsNotNull() {
            addCriterion("id_close is not null");
            return (Criteria) this;
        }

        public Criteria andIdCloseEqualTo(String value) {
            addCriterion("id_close =", value, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseNotEqualTo(String value) {
            addCriterion("id_close <>", value, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseGreaterThan(String value) {
            addCriterion("id_close >", value, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseGreaterThanOrEqualTo(String value) {
            addCriterion("id_close >=", value, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseLessThan(String value) {
            addCriterion("id_close <", value, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseLessThanOrEqualTo(String value) {
            addCriterion("id_close <=", value, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseLike(String value) {
            addCriterion("id_close like", value, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseNotLike(String value) {
            addCriterion("id_close not like", value, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseIn(List<String> values) {
            addCriterion("id_close in", values, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseNotIn(List<String> values) {
            addCriterion("id_close not in", values, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseBetween(String value1, String value2) {
            addCriterion("id_close between", value1, value2, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdCloseNotBetween(String value1, String value2) {
            addCriterion("id_close not between", value1, value2, "idClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseIsNull() {
            addCriterion("id_sub_close is null");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseIsNotNull() {
            addCriterion("id_sub_close is not null");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseEqualTo(String value) {
            addCriterion("id_sub_close =", value, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseNotEqualTo(String value) {
            addCriterion("id_sub_close <>", value, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseGreaterThan(String value) {
            addCriterion("id_sub_close >", value, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseGreaterThanOrEqualTo(String value) {
            addCriterion("id_sub_close >=", value, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseLessThan(String value) {
            addCriterion("id_sub_close <", value, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseLessThanOrEqualTo(String value) {
            addCriterion("id_sub_close <=", value, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseLike(String value) {
            addCriterion("id_sub_close like", value, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseNotLike(String value) {
            addCriterion("id_sub_close not like", value, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseIn(List<String> values) {
            addCriterion("id_sub_close in", values, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseNotIn(List<String> values) {
            addCriterion("id_sub_close not in", values, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseBetween(String value1, String value2) {
            addCriterion("id_sub_close between", value1, value2, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andIdSubCloseNotBetween(String value1, String value2) {
            addCriterion("id_sub_close not between", value1, value2, "idSubClose");
            return (Criteria) this;
        }

        public Criteria andPTimeIsNull() {
            addCriterion("p_time is null");
            return (Criteria) this;
        }

        public Criteria andPTimeIsNotNull() {
            addCriterion("p_time is not null");
            return (Criteria) this;
        }

        public Criteria andPTimeEqualTo(String value) {
            addCriterion("p_time =", value, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeNotEqualTo(String value) {
            addCriterion("p_time <>", value, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeGreaterThan(String value) {
            addCriterion("p_time >", value, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeGreaterThanOrEqualTo(String value) {
            addCriterion("p_time >=", value, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeLessThan(String value) {
            addCriterion("p_time <", value, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeLessThanOrEqualTo(String value) {
            addCriterion("p_time <=", value, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeLike(String value) {
            addCriterion("p_time like", value, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeNotLike(String value) {
            addCriterion("p_time not like", value, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeIn(List<String> values) {
            addCriterion("p_time in", values, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeNotIn(List<String> values) {
            addCriterion("p_time not in", values, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeBetween(String value1, String value2) {
            addCriterion("p_time between", value1, value2, "pTime");
            return (Criteria) this;
        }

        public Criteria andPTimeNotBetween(String value1, String value2) {
            addCriterion("p_time not between", value1, value2, "pTime");
            return (Criteria) this;
        }

        public Criteria andPLivingIsNull() {
            addCriterion("p_living is null");
            return (Criteria) this;
        }

        public Criteria andPLivingIsNotNull() {
            addCriterion("p_living is not null");
            return (Criteria) this;
        }

        public Criteria andPLivingEqualTo(String value) {
            addCriterion("p_living =", value, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingNotEqualTo(String value) {
            addCriterion("p_living <>", value, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingGreaterThan(String value) {
            addCriterion("p_living >", value, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingGreaterThanOrEqualTo(String value) {
            addCriterion("p_living >=", value, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingLessThan(String value) {
            addCriterion("p_living <", value, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingLessThanOrEqualTo(String value) {
            addCriterion("p_living <=", value, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingLike(String value) {
            addCriterion("p_living like", value, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingNotLike(String value) {
            addCriterion("p_living not like", value, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingIn(List<String> values) {
            addCriterion("p_living in", values, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingNotIn(List<String> values) {
            addCriterion("p_living not in", values, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingBetween(String value1, String value2) {
            addCriterion("p_living between", value1, value2, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPLivingNotBetween(String value1, String value2) {
            addCriterion("p_living not between", value1, value2, "pLiving");
            return (Criteria) this;
        }

        public Criteria andPFlowIsNull() {
            addCriterion("p_flow is null");
            return (Criteria) this;
        }

        public Criteria andPFlowIsNotNull() {
            addCriterion("p_flow is not null");
            return (Criteria) this;
        }

        public Criteria andPFlowEqualTo(String value) {
            addCriterion("p_flow =", value, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowNotEqualTo(String value) {
            addCriterion("p_flow <>", value, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowGreaterThan(String value) {
            addCriterion("p_flow >", value, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowGreaterThanOrEqualTo(String value) {
            addCriterion("p_flow >=", value, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowLessThan(String value) {
            addCriterion("p_flow <", value, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowLessThanOrEqualTo(String value) {
            addCriterion("p_flow <=", value, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowLike(String value) {
            addCriterion("p_flow like", value, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowNotLike(String value) {
            addCriterion("p_flow not like", value, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowIn(List<String> values) {
            addCriterion("p_flow in", values, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowNotIn(List<String> values) {
            addCriterion("p_flow not in", values, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowBetween(String value1, String value2) {
            addCriterion("p_flow between", value1, value2, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPFlowNotBetween(String value1, String value2) {
            addCriterion("p_flow not between", value1, value2, "pFlow");
            return (Criteria) this;
        }

        public Criteria andPNoteIsNull() {
            addCriterion("p_note is null");
            return (Criteria) this;
        }

        public Criteria andPNoteIsNotNull() {
            addCriterion("p_note is not null");
            return (Criteria) this;
        }

        public Criteria andPNoteEqualTo(String value) {
            addCriterion("p_note =", value, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteNotEqualTo(String value) {
            addCriterion("p_note <>", value, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteGreaterThan(String value) {
            addCriterion("p_note >", value, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteGreaterThanOrEqualTo(String value) {
            addCriterion("p_note >=", value, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteLessThan(String value) {
            addCriterion("p_note <", value, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteLessThanOrEqualTo(String value) {
            addCriterion("p_note <=", value, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteLike(String value) {
            addCriterion("p_note like", value, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteNotLike(String value) {
            addCriterion("p_note not like", value, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteIn(List<String> values) {
            addCriterion("p_note in", values, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteNotIn(List<String> values) {
            addCriterion("p_note not in", values, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteBetween(String value1, String value2) {
            addCriterion("p_note between", value1, value2, "pNote");
            return (Criteria) this;
        }

        public Criteria andPNoteNotBetween(String value1, String value2) {
            addCriterion("p_note not between", value1, value2, "pNote");
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