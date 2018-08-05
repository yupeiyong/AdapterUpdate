package login.first.yong.adapterupdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Data>_datas;
    private Context _context;
    public MyAdapter(Context context,List<Data>datas){
        this._context=context;
        this._datas=datas;
    }

    @Override
    public int getCount() {
        if(_datas!=null)
            return _datas.size();
        return 0;
    }

    @Override
    public Object getItem(int i) {
        if(_datas!=null && i<_datas.size())
            return _datas.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void add(Data item){
        if(item==null)
            return;
        if(_datas==null){
            _datas=new LinkedList<Data>();
        }
        _datas.add(item);
        notifyDataSetChanged();
    }

    public void add(Data item,int position){
        if(item==null)
            return;
        if(_datas==null){
            _datas=new LinkedList<Data>();
        }
        _datas.add(position,item);
        notifyDataSetChanged();
    }

    public void remove(Data data) {
        if(_datas != null) {
            _datas.remove(data);
        }
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if(_datas != null) {
            _datas.remove(position);
        }
        notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            view= LayoutInflater.from(_context).inflate(R.layout.item_list,viewGroup,false);
            holder=new ViewHolder();
            holder.img_icon=view.findViewById(R.id.img_icon);
            holder.txt_content=view.findViewById(R.id.txt_content);
            view.setTag(holder);
        }else{
            holder=(ViewHolder)view.getTag();
        }
        Data data=_datas.get(i);
        if(data!=null){
            holder.img_icon.setBackgroundResource(data.getImgId());
            holder.txt_content.setText(data.getContent());
        }
        return view;
    }
    private class ViewHolder{
        ImageView img_icon;
        TextView txt_content;
    }
}
