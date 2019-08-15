package com.treasy.treasy.service;

import com.treasy.treasy.models.NodeFilho;
import com.treasy.treasy.models.NodePai;
import com.treasy.treasy.repository.NodeFilhoRepository;
import com.treasy.treasy.repository.NodePaiRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class NodeService {

    private NodePaiRepository repository;
    private NodeFilhoRepository filhoRepository;

    public NodeService(  NodePaiRepository repository , NodeFilhoRepository filhoRepository ){
        this.repository = repository;
        this.filhoRepository = filhoRepository;
    }

    public NodePai save(NodePai nodePai){
        repository.save(nodePai);
        List<NodeFilho> nodeFilhos = nodePai.getChildren();
        for(NodeFilho nodeFilho : nodeFilhos ){
            nodeFilho.setNodePai(nodePai);
            nodeFilho.setParentId(nodePai.getId());
            nodeFilho.setHasChildren(true);
            filhoRepository.save(nodeFilho);
        }
        return nodePai;
    };

    public Collection<NodePai> findAll() {
        return repository.findAll();
    }


}
