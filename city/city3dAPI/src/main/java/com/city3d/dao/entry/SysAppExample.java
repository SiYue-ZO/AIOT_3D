package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class SysAppExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAppExample() {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppLogoIsNull() {
            addCriterion("app_logo is null");
            return (Criteria) this;
        }

        public Criteria andAppLogoIsNotNull() {
            addCriterion("app_logo is not null");
            return (Criteria) this;
        }

        public Criteria andAppLogoEqualTo(String value) {
            addCriterion("app_logo =", value, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoNotEqualTo(String value) {
            addCriterion("app_logo <>", value, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoGreaterThan(String value) {
            addCriterion("app_logo >", value, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoGreaterThanOrEqualTo(String value) {
            addCriterion("app_logo >=", value, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoLessThan(String value) {
            addCriterion("app_logo <", value, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoLessThanOrEqualTo(String value) {
            addCriterion("app_logo <=", value, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoLike(String value) {
            addCriterion("app_logo like", value, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoNotLike(String value) {
            addCriterion("app_logo not like", value, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoIn(List<String> values) {
            addCriterion("app_logo in", values, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoNotIn(List<String> values) {
            addCriterion("app_logo not in", values, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoBetween(String value1, String value2) {
            addCriterion("app_logo between", value1, value2, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppLogoNotBetween(String value1, String value2) {
            addCriterion("app_logo not between", value1, value2, "appLogo");
            return (Criteria) this;
        }

        public Criteria andAppUiModeIsNull() {
            addCriterion("app_ui_mode is null");
            return (Criteria) this;
        }

        public Criteria andAppUiModeIsNotNull() {
            addCriterion("app_ui_mode is not null");
            return (Criteria) this;
        }

        public Criteria andAppUiModeEqualTo(String value) {
            addCriterion("app_ui_mode =", value, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeNotEqualTo(String value) {
            addCriterion("app_ui_mode <>", value, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeGreaterThan(String value) {
            addCriterion("app_ui_mode >", value, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeGreaterThanOrEqualTo(String value) {
            addCriterion("app_ui_mode >=", value, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeLessThan(String value) {
            addCriterion("app_ui_mode <", value, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeLessThanOrEqualTo(String value) {
            addCriterion("app_ui_mode <=", value, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeLike(String value) {
            addCriterion("app_ui_mode like", value, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeNotLike(String value) {
            addCriterion("app_ui_mode not like", value, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeIn(List<String> values) {
            addCriterion("app_ui_mode in", values, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeNotIn(List<String> values) {
            addCriterion("app_ui_mode not in", values, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeBetween(String value1, String value2) {
            addCriterion("app_ui_mode between", value1, value2, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppUiModeNotBetween(String value1, String value2) {
            addCriterion("app_ui_mode not between", value1, value2, "appUiMode");
            return (Criteria) this;
        }

        public Criteria andAppPosIsNull() {
            addCriterion("app_pos is null");
            return (Criteria) this;
        }

        public Criteria andAppPosIsNotNull() {
            addCriterion("app_pos is not null");
            return (Criteria) this;
        }

        public Criteria andAppPosEqualTo(String value) {
            addCriterion("app_pos =", value, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosNotEqualTo(String value) {
            addCriterion("app_pos <>", value, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosGreaterThan(String value) {
            addCriterion("app_pos >", value, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosGreaterThanOrEqualTo(String value) {
            addCriterion("app_pos >=", value, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosLessThan(String value) {
            addCriterion("app_pos <", value, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosLessThanOrEqualTo(String value) {
            addCriterion("app_pos <=", value, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosLike(String value) {
            addCriterion("app_pos like", value, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosNotLike(String value) {
            addCriterion("app_pos not like", value, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosIn(List<String> values) {
            addCriterion("app_pos in", values, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosNotIn(List<String> values) {
            addCriterion("app_pos not in", values, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosBetween(String value1, String value2) {
            addCriterion("app_pos between", value1, value2, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppPosNotBetween(String value1, String value2) {
            addCriterion("app_pos not between", value1, value2, "appPos");
            return (Criteria) this;
        }

        public Criteria andAppImageIsNull() {
            addCriterion("app_image is null");
            return (Criteria) this;
        }

        public Criteria andAppImageIsNotNull() {
            addCriterion("app_image is not null");
            return (Criteria) this;
        }

        public Criteria andAppImageEqualTo(String value) {
            addCriterion("app_image =", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageNotEqualTo(String value) {
            addCriterion("app_image <>", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageGreaterThan(String value) {
            addCriterion("app_image >", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageGreaterThanOrEqualTo(String value) {
            addCriterion("app_image >=", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageLessThan(String value) {
            addCriterion("app_image <", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageLessThanOrEqualTo(String value) {
            addCriterion("app_image <=", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageLike(String value) {
            addCriterion("app_image like", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageNotLike(String value) {
            addCriterion("app_image not like", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageIn(List<String> values) {
            addCriterion("app_image in", values, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageNotIn(List<String> values) {
            addCriterion("app_image not in", values, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageBetween(String value1, String value2) {
            addCriterion("app_image between", value1, value2, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageNotBetween(String value1, String value2) {
            addCriterion("app_image not between", value1, value2, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppTerrainIsNull() {
            addCriterion("app_terrain is null");
            return (Criteria) this;
        }

        public Criteria andAppTerrainIsNotNull() {
            addCriterion("app_terrain is not null");
            return (Criteria) this;
        }

        public Criteria andAppTerrainEqualTo(String value) {
            addCriterion("app_terrain =", value, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainNotEqualTo(String value) {
            addCriterion("app_terrain <>", value, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainGreaterThan(String value) {
            addCriterion("app_terrain >", value, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainGreaterThanOrEqualTo(String value) {
            addCriterion("app_terrain >=", value, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainLessThan(String value) {
            addCriterion("app_terrain <", value, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainLessThanOrEqualTo(String value) {
            addCriterion("app_terrain <=", value, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainLike(String value) {
            addCriterion("app_terrain like", value, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainNotLike(String value) {
            addCriterion("app_terrain not like", value, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainIn(List<String> values) {
            addCriterion("app_terrain in", values, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainNotIn(List<String> values) {
            addCriterion("app_terrain not in", values, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainBetween(String value1, String value2) {
            addCriterion("app_terrain between", value1, value2, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppTerrainNotBetween(String value1, String value2) {
            addCriterion("app_terrain not between", value1, value2, "appTerrain");
            return (Criteria) this;
        }

        public Criteria andAppVersionIsNull() {
            addCriterion("app_version is null");
            return (Criteria) this;
        }

        public Criteria andAppVersionIsNotNull() {
            addCriterion("app_version is not null");
            return (Criteria) this;
        }

        public Criteria andAppVersionEqualTo(String value) {
            addCriterion("app_version =", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotEqualTo(String value) {
            addCriterion("app_version <>", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThan(String value) {
            addCriterion("app_version >", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThanOrEqualTo(String value) {
            addCriterion("app_version >=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThan(String value) {
            addCriterion("app_version <", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThanOrEqualTo(String value) {
            addCriterion("app_version <=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLike(String value) {
            addCriterion("app_version like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotLike(String value) {
            addCriterion("app_version not like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionIn(List<String> values) {
            addCriterion("app_version in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotIn(List<String> values) {
            addCriterion("app_version not in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionBetween(String value1, String value2) {
            addCriterion("app_version between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotBetween(String value1, String value2) {
            addCriterion("app_version not between", value1, value2, "appVersion");
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