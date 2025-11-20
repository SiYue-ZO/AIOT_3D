package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class SecurityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecurityExample() {
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

        public Criteria andSecurityIdIsNull() {
            addCriterion("security_id is null");
            return (Criteria) this;
        }

        public Criteria andSecurityIdIsNotNull() {
            addCriterion("security_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityIdEqualTo(String value) {
            addCriterion("security_id =", value, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdNotEqualTo(String value) {
            addCriterion("security_id <>", value, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdGreaterThan(String value) {
            addCriterion("security_id >", value, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdGreaterThanOrEqualTo(String value) {
            addCriterion("security_id >=", value, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdLessThan(String value) {
            addCriterion("security_id <", value, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdLessThanOrEqualTo(String value) {
            addCriterion("security_id <=", value, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdLike(String value) {
            addCriterion("security_id like", value, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdNotLike(String value) {
            addCriterion("security_id not like", value, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdIn(List<String> values) {
            addCriterion("security_id in", values, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdNotIn(List<String> values) {
            addCriterion("security_id not in", values, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdBetween(String value1, String value2) {
            addCriterion("security_id between", value1, value2, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityIdNotBetween(String value1, String value2) {
            addCriterion("security_id not between", value1, value2, "securityId");
            return (Criteria) this;
        }

        public Criteria andSecurityNameIsNull() {
            addCriterion("security_name is null");
            return (Criteria) this;
        }

        public Criteria andSecurityNameIsNotNull() {
            addCriterion("security_name is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityNameEqualTo(String value) {
            addCriterion("security_name =", value, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameNotEqualTo(String value) {
            addCriterion("security_name <>", value, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameGreaterThan(String value) {
            addCriterion("security_name >", value, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameGreaterThanOrEqualTo(String value) {
            addCriterion("security_name >=", value, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameLessThan(String value) {
            addCriterion("security_name <", value, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameLessThanOrEqualTo(String value) {
            addCriterion("security_name <=", value, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameLike(String value) {
            addCriterion("security_name like", value, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameNotLike(String value) {
            addCriterion("security_name not like", value, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameIn(List<String> values) {
            addCriterion("security_name in", values, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameNotIn(List<String> values) {
            addCriterion("security_name not in", values, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameBetween(String value1, String value2) {
            addCriterion("security_name between", value1, value2, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityNameNotBetween(String value1, String value2) {
            addCriterion("security_name not between", value1, value2, "securityName");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeIsNull() {
            addCriterion("security_type is null");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeIsNotNull() {
            addCriterion("security_type is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeEqualTo(String value) {
            addCriterion("security_type =", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeNotEqualTo(String value) {
            addCriterion("security_type <>", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeGreaterThan(String value) {
            addCriterion("security_type >", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("security_type >=", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeLessThan(String value) {
            addCriterion("security_type <", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeLessThanOrEqualTo(String value) {
            addCriterion("security_type <=", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeLike(String value) {
            addCriterion("security_type like", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeNotLike(String value) {
            addCriterion("security_type not like", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeIn(List<String> values) {
            addCriterion("security_type in", values, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeNotIn(List<String> values) {
            addCriterion("security_type not in", values, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeBetween(String value1, String value2) {
            addCriterion("security_type between", value1, value2, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeNotBetween(String value1, String value2) {
            addCriterion("security_type not between", value1, value2, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdIsNull() {
            addCriterion("security_police_id is null");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdIsNotNull() {
            addCriterion("security_police_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdEqualTo(String value) {
            addCriterion("security_police_id =", value, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdNotEqualTo(String value) {
            addCriterion("security_police_id <>", value, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdGreaterThan(String value) {
            addCriterion("security_police_id >", value, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdGreaterThanOrEqualTo(String value) {
            addCriterion("security_police_id >=", value, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdLessThan(String value) {
            addCriterion("security_police_id <", value, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdLessThanOrEqualTo(String value) {
            addCriterion("security_police_id <=", value, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdLike(String value) {
            addCriterion("security_police_id like", value, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdNotLike(String value) {
            addCriterion("security_police_id not like", value, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdIn(List<String> values) {
            addCriterion("security_police_id in", values, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdNotIn(List<String> values) {
            addCriterion("security_police_id not in", values, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdBetween(String value1, String value2) {
            addCriterion("security_police_id between", value1, value2, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityPoliceIdNotBetween(String value1, String value2) {
            addCriterion("security_police_id not between", value1, value2, "securityPoliceId");
            return (Criteria) this;
        }

        public Criteria andSecurityTelIsNull() {
            addCriterion("security_tel is null");
            return (Criteria) this;
        }

        public Criteria andSecurityTelIsNotNull() {
            addCriterion("security_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityTelEqualTo(String value) {
            addCriterion("security_tel =", value, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelNotEqualTo(String value) {
            addCriterion("security_tel <>", value, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelGreaterThan(String value) {
            addCriterion("security_tel >", value, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelGreaterThanOrEqualTo(String value) {
            addCriterion("security_tel >=", value, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelLessThan(String value) {
            addCriterion("security_tel <", value, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelLessThanOrEqualTo(String value) {
            addCriterion("security_tel <=", value, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelLike(String value) {
            addCriterion("security_tel like", value, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelNotLike(String value) {
            addCriterion("security_tel not like", value, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelIn(List<String> values) {
            addCriterion("security_tel in", values, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelNotIn(List<String> values) {
            addCriterion("security_tel not in", values, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelBetween(String value1, String value2) {
            addCriterion("security_tel between", value1, value2, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityTelNotBetween(String value1, String value2) {
            addCriterion("security_tel not between", value1, value2, "securityTel");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeIsNull() {
            addCriterion("security_describe is null");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeIsNotNull() {
            addCriterion("security_describe is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeEqualTo(String value) {
            addCriterion("security_describe =", value, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeNotEqualTo(String value) {
            addCriterion("security_describe <>", value, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeGreaterThan(String value) {
            addCriterion("security_describe >", value, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("security_describe >=", value, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeLessThan(String value) {
            addCriterion("security_describe <", value, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeLessThanOrEqualTo(String value) {
            addCriterion("security_describe <=", value, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeLike(String value) {
            addCriterion("security_describe like", value, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeNotLike(String value) {
            addCriterion("security_describe not like", value, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeIn(List<String> values) {
            addCriterion("security_describe in", values, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeNotIn(List<String> values) {
            addCriterion("security_describe not in", values, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeBetween(String value1, String value2) {
            addCriterion("security_describe between", value1, value2, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityDescribeNotBetween(String value1, String value2) {
            addCriterion("security_describe not between", value1, value2, "securityDescribe");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiIsNull() {
            addCriterion("security_poi is null");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiIsNotNull() {
            addCriterion("security_poi is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiEqualTo(String value) {
            addCriterion("security_poi =", value, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiNotEqualTo(String value) {
            addCriterion("security_poi <>", value, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiGreaterThan(String value) {
            addCriterion("security_poi >", value, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiGreaterThanOrEqualTo(String value) {
            addCriterion("security_poi >=", value, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiLessThan(String value) {
            addCriterion("security_poi <", value, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiLessThanOrEqualTo(String value) {
            addCriterion("security_poi <=", value, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiLike(String value) {
            addCriterion("security_poi like", value, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiNotLike(String value) {
            addCriterion("security_poi not like", value, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiIn(List<String> values) {
            addCriterion("security_poi in", values, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiNotIn(List<String> values) {
            addCriterion("security_poi not in", values, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiBetween(String value1, String value2) {
            addCriterion("security_poi between", value1, value2, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityPoiNotBetween(String value1, String value2) {
            addCriterion("security_poi not between", value1, value2, "securityPoi");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterIsNull() {
            addCriterion("security_center is null");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterIsNotNull() {
            addCriterion("security_center is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterEqualTo(String value) {
            addCriterion("security_center =", value, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterNotEqualTo(String value) {
            addCriterion("security_center <>", value, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterGreaterThan(String value) {
            addCriterion("security_center >", value, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterGreaterThanOrEqualTo(String value) {
            addCriterion("security_center >=", value, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterLessThan(String value) {
            addCriterion("security_center <", value, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterLessThanOrEqualTo(String value) {
            addCriterion("security_center <=", value, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterLike(String value) {
            addCriterion("security_center like", value, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterNotLike(String value) {
            addCriterion("security_center not like", value, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterIn(List<String> values) {
            addCriterion("security_center in", values, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterNotIn(List<String> values) {
            addCriterion("security_center not in", values, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterBetween(String value1, String value2) {
            addCriterion("security_center between", value1, value2, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityCenterNotBetween(String value1, String value2) {
            addCriterion("security_center not between", value1, value2, "securityCenter");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdIsNull() {
            addCriterion("security_video_id is null");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdIsNotNull() {
            addCriterion("security_video_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdEqualTo(String value) {
            addCriterion("security_video_id =", value, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdNotEqualTo(String value) {
            addCriterion("security_video_id <>", value, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdGreaterThan(String value) {
            addCriterion("security_video_id >", value, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdGreaterThanOrEqualTo(String value) {
            addCriterion("security_video_id >=", value, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdLessThan(String value) {
            addCriterion("security_video_id <", value, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdLessThanOrEqualTo(String value) {
            addCriterion("security_video_id <=", value, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdLike(String value) {
            addCriterion("security_video_id like", value, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdNotLike(String value) {
            addCriterion("security_video_id not like", value, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdIn(List<String> values) {
            addCriterion("security_video_id in", values, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdNotIn(List<String> values) {
            addCriterion("security_video_id not in", values, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdBetween(String value1, String value2) {
            addCriterion("security_video_id between", value1, value2, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andSecurityVideoIdNotBetween(String value1, String value2) {
            addCriterion("security_video_id not between", value1, value2, "securityVideoId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(String value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(String value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(String value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLike(String value) {
            addCriterion("equipment_id like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotLike(String value) {
            addCriterion("equipment_id not like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<String> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<String> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(String value1, String value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityIsNull() {
            addCriterion("security_community is null");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityIsNotNull() {
            addCriterion("security_community is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityEqualTo(String value) {
            addCriterion("security_community =", value, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityNotEqualTo(String value) {
            addCriterion("security_community <>", value, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityGreaterThan(String value) {
            addCriterion("security_community >", value, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityGreaterThanOrEqualTo(String value) {
            addCriterion("security_community >=", value, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityLessThan(String value) {
            addCriterion("security_community <", value, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityLessThanOrEqualTo(String value) {
            addCriterion("security_community <=", value, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityLike(String value) {
            addCriterion("security_community like", value, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityNotLike(String value) {
            addCriterion("security_community not like", value, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityIn(List<String> values) {
            addCriterion("security_community in", values, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityNotIn(List<String> values) {
            addCriterion("security_community not in", values, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityBetween(String value1, String value2) {
            addCriterion("security_community between", value1, value2, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andSecurityCommunityNotBetween(String value1, String value2) {
            addCriterion("security_community not between", value1, value2, "securityCommunity");
            return (Criteria) this;
        }

        public Criteria andNetMasterIsNull() {
            addCriterion("net_master is null");
            return (Criteria) this;
        }

        public Criteria andNetMasterIsNotNull() {
            addCriterion("net_master is not null");
            return (Criteria) this;
        }

        public Criteria andNetMasterEqualTo(String value) {
            addCriterion("net_master =", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterNotEqualTo(String value) {
            addCriterion("net_master <>", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterGreaterThan(String value) {
            addCriterion("net_master >", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterGreaterThanOrEqualTo(String value) {
            addCriterion("net_master >=", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterLessThan(String value) {
            addCriterion("net_master <", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterLessThanOrEqualTo(String value) {
            addCriterion("net_master <=", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterLike(String value) {
            addCriterion("net_master like", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterNotLike(String value) {
            addCriterion("net_master not like", value, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterIn(List<String> values) {
            addCriterion("net_master in", values, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterNotIn(List<String> values) {
            addCriterion("net_master not in", values, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterBetween(String value1, String value2) {
            addCriterion("net_master between", value1, value2, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetMasterNotBetween(String value1, String value2) {
            addCriterion("net_master not between", value1, value2, "netMaster");
            return (Criteria) this;
        }

        public Criteria andNetListenerIsNull() {
            addCriterion("net_listener is null");
            return (Criteria) this;
        }

        public Criteria andNetListenerIsNotNull() {
            addCriterion("net_listener is not null");
            return (Criteria) this;
        }

        public Criteria andNetListenerEqualTo(String value) {
            addCriterion("net_listener =", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerNotEqualTo(String value) {
            addCriterion("net_listener <>", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerGreaterThan(String value) {
            addCriterion("net_listener >", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerGreaterThanOrEqualTo(String value) {
            addCriterion("net_listener >=", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerLessThan(String value) {
            addCriterion("net_listener <", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerLessThanOrEqualTo(String value) {
            addCriterion("net_listener <=", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerLike(String value) {
            addCriterion("net_listener like", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerNotLike(String value) {
            addCriterion("net_listener not like", value, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerIn(List<String> values) {
            addCriterion("net_listener in", values, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerNotIn(List<String> values) {
            addCriterion("net_listener not in", values, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerBetween(String value1, String value2) {
            addCriterion("net_listener between", value1, value2, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetListenerNotBetween(String value1, String value2) {
            addCriterion("net_listener not between", value1, value2, "netListener");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleIsNull() {
            addCriterion("net_base_people is null");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleIsNotNull() {
            addCriterion("net_base_people is not null");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleEqualTo(String value) {
            addCriterion("net_base_people =", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleNotEqualTo(String value) {
            addCriterion("net_base_people <>", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleGreaterThan(String value) {
            addCriterion("net_base_people >", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("net_base_people >=", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleLessThan(String value) {
            addCriterion("net_base_people <", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleLessThanOrEqualTo(String value) {
            addCriterion("net_base_people <=", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleLike(String value) {
            addCriterion("net_base_people like", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleNotLike(String value) {
            addCriterion("net_base_people not like", value, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleIn(List<String> values) {
            addCriterion("net_base_people in", values, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleNotIn(List<String> values) {
            addCriterion("net_base_people not in", values, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleBetween(String value1, String value2) {
            addCriterion("net_base_people between", value1, value2, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetBasePeopleNotBetween(String value1, String value2) {
            addCriterion("net_base_people not between", value1, value2, "netBasePeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleIsNull() {
            addCriterion("net_hold_people is null");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleIsNotNull() {
            addCriterion("net_hold_people is not null");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleEqualTo(String value) {
            addCriterion("net_hold_people =", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleNotEqualTo(String value) {
            addCriterion("net_hold_people <>", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleGreaterThan(String value) {
            addCriterion("net_hold_people >", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("net_hold_people >=", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleLessThan(String value) {
            addCriterion("net_hold_people <", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleLessThanOrEqualTo(String value) {
            addCriterion("net_hold_people <=", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleLike(String value) {
            addCriterion("net_hold_people like", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleNotLike(String value) {
            addCriterion("net_hold_people not like", value, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleIn(List<String> values) {
            addCriterion("net_hold_people in", values, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleNotIn(List<String> values) {
            addCriterion("net_hold_people not in", values, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleBetween(String value1, String value2) {
            addCriterion("net_hold_people between", value1, value2, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetHoldPeopleNotBetween(String value1, String value2) {
            addCriterion("net_hold_people not between", value1, value2, "netHoldPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleIsNull() {
            addCriterion("net_flow_people is null");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleIsNotNull() {
            addCriterion("net_flow_people is not null");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleEqualTo(String value) {
            addCriterion("net_flow_people =", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleNotEqualTo(String value) {
            addCriterion("net_flow_people <>", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleGreaterThan(String value) {
            addCriterion("net_flow_people >", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("net_flow_people >=", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleLessThan(String value) {
            addCriterion("net_flow_people <", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleLessThanOrEqualTo(String value) {
            addCriterion("net_flow_people <=", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleLike(String value) {
            addCriterion("net_flow_people like", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleNotLike(String value) {
            addCriterion("net_flow_people not like", value, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleIn(List<String> values) {
            addCriterion("net_flow_people in", values, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleNotIn(List<String> values) {
            addCriterion("net_flow_people not in", values, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleBetween(String value1, String value2) {
            addCriterion("net_flow_people between", value1, value2, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetFlowPeopleNotBetween(String value1, String value2) {
            addCriterion("net_flow_people not between", value1, value2, "netFlowPeople");
            return (Criteria) this;
        }

        public Criteria andNetGroupIsNull() {
            addCriterion("net_group is null");
            return (Criteria) this;
        }

        public Criteria andNetGroupIsNotNull() {
            addCriterion("net_group is not null");
            return (Criteria) this;
        }

        public Criteria andNetGroupEqualTo(String value) {
            addCriterion("net_group =", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupNotEqualTo(String value) {
            addCriterion("net_group <>", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupGreaterThan(String value) {
            addCriterion("net_group >", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupGreaterThanOrEqualTo(String value) {
            addCriterion("net_group >=", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupLessThan(String value) {
            addCriterion("net_group <", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupLessThanOrEqualTo(String value) {
            addCriterion("net_group <=", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupLike(String value) {
            addCriterion("net_group like", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupNotLike(String value) {
            addCriterion("net_group not like", value, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupIn(List<String> values) {
            addCriterion("net_group in", values, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupNotIn(List<String> values) {
            addCriterion("net_group not in", values, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupBetween(String value1, String value2) {
            addCriterion("net_group between", value1, value2, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetGroupNotBetween(String value1, String value2) {
            addCriterion("net_group not between", value1, value2, "netGroup");
            return (Criteria) this;
        }

        public Criteria andNetNoteIsNull() {
            addCriterion("net_note is null");
            return (Criteria) this;
        }

        public Criteria andNetNoteIsNotNull() {
            addCriterion("net_note is not null");
            return (Criteria) this;
        }

        public Criteria andNetNoteEqualTo(String value) {
            addCriterion("net_note =", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteNotEqualTo(String value) {
            addCriterion("net_note <>", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteGreaterThan(String value) {
            addCriterion("net_note >", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteGreaterThanOrEqualTo(String value) {
            addCriterion("net_note >=", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteLessThan(String value) {
            addCriterion("net_note <", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteLessThanOrEqualTo(String value) {
            addCriterion("net_note <=", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteLike(String value) {
            addCriterion("net_note like", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteNotLike(String value) {
            addCriterion("net_note not like", value, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteIn(List<String> values) {
            addCriterion("net_note in", values, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteNotIn(List<String> values) {
            addCriterion("net_note not in", values, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteBetween(String value1, String value2) {
            addCriterion("net_note between", value1, value2, "netNote");
            return (Criteria) this;
        }

        public Criteria andNetNoteNotBetween(String value1, String value2) {
            addCriterion("net_note not between", value1, value2, "netNote");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
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