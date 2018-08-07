package login.first.yong.adapterupdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
        if(item==null||_datas==null)
            return;

        _datas.add(item);
        notifyDataSetChanged();
    }

    public void add(Data item,int position){
        if(item==null||_datas==null)
            return;

        _datas.add(position,item);
        notifyDataSetChanged();
    }

    public void remove(Data data) {
        if(_datas != null) {
            _datas.remove(data);
        }
        notifyDataSetChanged();
    }

    private void remove(int position) {
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
            holder.btn_remove_item=view.findViewById(R.id.btnRemoveItem);
            view.setTag(holder);
        }else{
            holder=(ViewHolder)view.getTag();
        }
        Data data=_datas.get(i);
        if(data!=null){
            holder.img_icon.setBackgroundResource(data.getImgId());
            holder.txt_content.setText(data.getContent());
        }
        holder.btn_remove_item.setTag(i);
        holder.btn_remove_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index=(int)view.getTag();
                remove(index);
            }
        });
        return view;
    }
    private static class ViewHolder{
        ImageView img_icon;
        TextView txt_content;
        Button btn_remove_item;
    }
}
