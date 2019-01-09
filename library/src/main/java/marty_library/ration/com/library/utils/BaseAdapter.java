package marty_library.ration.com.library.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Marty
 * Date: 2018-11-02
 * Time: 오후 2:47
 * Description:
 */
public abstract class BaseAdapter<T,S extends BaseVH> extends RecyclerView.Adapter<S> {

    public ArrayList<T> arrayList = new ArrayList<>();
    private Context mCon;
    private LayoutInflater mInflater;
    private Integer mLayout;

    OnItemClickListener<T> onItemClickListener;

    public BaseAdapter(Context mCon , Integer mLayout) {
        this.mCon = mCon;
        this.mLayout = mLayout;
        mInflater = (LayoutInflater)mCon.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public Context getmCon() {
        return mCon;
    }

    public void setList(ArrayList<T> t){
        arrayList = t;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void addList(ArrayList<T> t){
        if (arrayList == null)
            arrayList = new ArrayList<>();
        int pos = arrayList.size();
        arrayList.addAll(t);
        notifyItemRangeChanged(pos,arrayList.size());

    }

    public void addList(T t){
        if (arrayList == null)
            arrayList = new ArrayList<>();
        arrayList.add(t);
        notifyItemInserted(arrayList.size()-1);

    }

    @Override
    public void onBindViewHolder(@NonNull final S holder, final int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.itemView,arrayList.get(position));
                }
            });
        }
    }

    @NonNull
    @Override
    public S onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return getViewHolder(mInflater.inflate(mLayout,viewGroup,false));
    }

    public abstract S getViewHolder(View view);

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}