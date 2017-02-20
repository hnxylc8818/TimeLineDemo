package cn.demo.timeline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.demo.timeline.R;
import cn.demo.timeline.entity.TimeLine;
import cn.demo.timeline.fulllistview.NestFullListView;
import cn.demo.timeline.fulllistview.NestFullListViewAdapter;
import cn.demo.timeline.fulllistview.NestFullViewHolder;

/**
 * Created by Administrator on 2017/2/18.
 */

public class TimeLineAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<TimeLine.RowsBean> rowsBeanList;

    public TimeLineAdapter(Context context, List<TimeLine.RowsBean> rowsBeanList) {
        this.context = context;
        if (rowsBeanList == null){
            this.rowsBeanList = new ArrayList<>();
        }else {
            this.rowsBeanList = rowsBeanList;
        }
    }

    @Override
    public int getGroupCount() {
        return rowsBeanList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return rowsBeanList.get(groupPosition).getDaylist().size();
    }

    @Override
    public TimeLine.RowsBean getGroup(int groupPosition) {
        return rowsBeanList.get(groupPosition);
    }

    @Override
    public TimeLine.RowsBean.DaylistBean getChild(int groupPosition, int childPosition) {
        return rowsBeanList.get(groupPosition).getDaylist().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if (convertView == null){
            groupHolder = new GroupHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_group_timeline,null);
            groupHolder.itemGroupTopLine = convertView.findViewById(R.id.item_group_top_line);
            groupHolder.itemGroupYearMonth = (TextView) convertView.findViewById(R.id.item_group_year_month);
            convertView.setTag(groupHolder);
        }else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        if (groupPosition == 0){
            groupHolder.itemGroupTopLine.setVisibility(View.INVISIBLE);
        }else {
            groupHolder.itemGroupTopLine.setVisibility(View.VISIBLE);
        }
        TimeLine.RowsBean rowsBean = getGroup(groupPosition);
        if (null != rowsBean){
            groupHolder.itemGroupYearMonth.setText(rowsBean.getMonth() +"月" + "\n" + rowsBean.getYear());
        }
        return convertView;
    }

    class GroupHolder {
        View itemGroupTopLine;
        TextView itemGroupYearMonth;
        View itemGroupBottomLine;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null){
            childHolder = new ChildHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_child_timeline,null);
            childHolder.itemChildMonthDay = (TextView) convertView.findViewById(R.id.item_child_month_day);
            childHolder.itemChildLv = (NestFullListView) convertView.findViewById(R.id.item_child_lv);
            convertView.setTag(childHolder);
        }else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        TimeLine.RowsBean.DaylistBean daylistBean = getChild(groupPosition, childPosition);
        if (null != daylistBean){
            childHolder.itemChildMonthDay.setText(daylistBean.getMonth() + "月" + daylistBean.getDay() + "日");
            childHolder.itemChildLv.setAdapter(new NestFullListViewAdapter<TimeLine.RowsBean.DaylistBean.DatalistBean>(R.layout.item_child_timeline_data,daylistBean.getDatalist()) {
                @Override
                public void onBind(int pos, TimeLine.RowsBean.DaylistBean.DatalistBean datalistBean, NestFullViewHolder holder) {
                    holder.setText(R.id.item_child_sr_name,datalistBean.getName());
                    holder.setText(R.id.item_child_sr_progress,datalistBean.getProgress() + "%");
                }
            });
        }

        return convertView;
    }

    class ChildHolder{
        TextView itemChildMonthDay;
        NestFullListView itemChildLv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public void add(List<TimeLine.RowsBean> rowsBeanList){
        if (null != rowsBeanList && rowsBeanList.size() != 0){
            this.rowsBeanList.addAll(rowsBeanList);
            notifyDataSetChanged();
        }
    }
}
